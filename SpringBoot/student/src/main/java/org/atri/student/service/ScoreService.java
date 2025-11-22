package org.atri.student.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.atri.student.entity.Score;
import org.atri.student.mapper.ScoreMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ScoreService {
    private final ScoreMapper scoreMapper;

    public ScoreService(ScoreMapper scoreMapper) {
        this.scoreMapper = scoreMapper;
    }

    public List<Score> listAll() {
        return scoreMapper.selectList(null);
    }

    @Transactional
    public Score create(Score score) {
        scoreMapper.insert(score);
        return score;
    }

    @Transactional
    public Optional<Score> update(Long id, Score score) {
        Score existing = scoreMapper.selectById(id);
        if (existing == null) {
            return Optional.empty();
        }
        existing.setSubjects(score.getSubjects());
        existing.setTimeStart(score.getTimeStart());
        existing.setTimeEnd(score.getTimeEnd());
        existing.setNumber(score.getNumber());
        existing.setGrade(score.getGrade());
        existing.setTeacher(score.getTeacher());
        scoreMapper.updateById(existing);
        return Optional.of(existing);
    }

    @Transactional
    public boolean delete(Long id) {
        return scoreMapper.deleteById(id) > 0;
    }

    public List<Score> selectBySubjects(String subjects) {
        return scoreMapper.selectList(
                         new QueryWrapper<Score>()
                        .eq("subjects", subjects)
                        .orderByAsc("time_start")

        );
    }


    public Map<String, List<Score>> listBySubjectsAndName(String subjects) {
        List<Score> subList = selectBySubjects(subjects);

        Map<String, List<Score>> studentScores = new HashMap<>();

        for (Score score : subList) {
            String studentNumber = score.getNumber();
            studentScores.computeIfAbsent(studentNumber, k -> new ArrayList<>()).add(score);
        }

        return studentScores;
    }

    public Optional<ImprovementResult> findBestImprovement(String subjects) {
        // 获取按学生分组的成绩
        Map<String, List<Score>> studentScores = listBySubjectsAndName(subjects);

        ImprovementResult bestImprovement = null;

        // 遍历每个
        for (Map.Entry<String, List<Score>> entry : studentScores.entrySet()) {
            String studentNumber = entry.getKey();
            List<Score> scores = entry.getValue();

            // 至少需要两次成绩才能比较进步
            if (scores.size() < 2) {
                continue;
            }

            // 按时间排序成绩
            scores.sort(Comparator.comparing(Score::getTimeStart));

            // 比较相邻两次成绩
            for (int i = 1; i < scores.size(); i++) {
                Score previousScore = scores.get(i - 1);
                Score currentScore = scores.get(i);

                try {
                    double previousGrade = Double.parseDouble(previousScore.getGrade());
                    double currentGrade = Double.parseDouble(currentScore.getGrade());
                    double improvement = currentGrade - previousGrade;

                    // 只考虑进步的情况
                    if (improvement > 0) {
                        if (bestImprovement == null || improvement > bestImprovement.improvementSteps()) {
                            bestImprovement = new ImprovementResult(
                                    subjects,
                                    previousScore.getTimeStart(),
                                    currentScore.getTimeStart(),
                                    studentNumber,
                                    0, // previousRank
                                    0, // currentRank
                                    (int) improvement, // improvementSteps
                                    currentScore
                            );
                        }
                    }
                } catch (NumberFormatException ignored) {

                }
            }
        }

        return Optional.ofNullable(bestImprovement);
    }
    public record ImprovementResult(String subject, String previousExamTimeStart, String currentExamTimeStart,
                                    String studentNumber, int previousRank, int currentRank, int improvementSteps,
                                    Score currentScore) {
    }

    /**
     * 获取指定学生在所有科目中的历次考试排名变化
     * @param studentNumber 学生编号
     * @return 该学生在所有科目中的排名变化记录
     */
    public List<RankChangeRecord> getAllRankChangesByStudent(String studentNumber) {
        // 获取指定学生的所有成绩
        List<Score> studentScores = scoreMapper.selectList(
                new QueryWrapper<Score>()
                        .eq("number", studentNumber)
                        .orderByAsc("time_start")
        );

        List<RankChangeRecord> rankChanges = new ArrayList<>();

        // 计算每次考试的排名
        for (Score score : studentScores) {
            if (score.getGrade() == null) continue;

            try {
                double grade = Double.parseDouble(score.getGrade());

                // 获取同一科目同一时间所有学生的成绩用于排名计算
                List<Score> allSubjectScoresAtTime = scoreMapper.selectList(
                        new QueryWrapper<Score>()
                                .eq("subjects", score.getSubjects())
                                .eq("time_start", score.getTimeStart())
                                .orderByDesc("grade")  // 按成绩降序排列
                );

                // 计算当前成绩的排名（从1开始）
                int rank = 1;
                for (Score otherScore : allSubjectScoresAtTime) {
                    if (otherScore.getNumber().equals(studentNumber)) {
                        break;  // 跳过自己的成绩
                    }

                    if (otherScore.getGrade() != null) {
                        try {
                            double otherGrade = Double.parseDouble(otherScore.getGrade());
                            if (otherGrade > grade) {
                                rank++;
                            }
                        } catch (NumberFormatException ignored) {}
                    }
                }

                RankChangeRecord record = new RankChangeRecord(
                        score.getTimeStart() + " (" + score.getSubjects() + ")",
                        rank,
                        grade
                );
                rankChanges.add(record);

            } catch (NumberFormatException ignored) {}
        }

        return rankChanges;
    }

    /**
     * 分析指定考生在某一科目下的历次排名变化情况
     * @param studentNumber 学生编号
     * @param subjects 科目名称
     * @return 排名变化记录列表，按时间排序
     */
    public List<RankChangeRecord> analyzeRankChanges(String studentNumber, String subjects) {
        // 获取指定学生在该科目的所有成绩
        List<Score> studentScores = scoreMapper.selectList(
                new QueryWrapper<Score>()
                        .eq("number", studentNumber)
                        .eq("subjects", subjects)
                        .orderByAsc("time_start")
        );

        List<RankChangeRecord> rankChanges = new ArrayList<>();

        // 计算每次考试的排名
        for (Score score : studentScores) {
            if (score.getGrade() == null) continue;

            try {
                double grade = Double.parseDouble(score.getGrade());
                
                // 获取同一科目同一时间所有学生的成绩用于排名计算
                List<Score> allSubjectScoresAtTime = scoreMapper.selectList(
                        new QueryWrapper<Score>()
                                .eq("subjects", subjects)
                                .eq("time_start", score.getTimeStart())
                                .orderByDesc("grade")  // 按成绩降序排列
                );

                // 计算当前成绩的排名（从1开始）
                int rank = 1;
                for (Score otherScore : allSubjectScoresAtTime) {
                    if (otherScore.getNumber().equals(studentNumber)) {
                        break;  // 跳过自己的成绩
                    }

                    if (otherScore.getGrade() != null) {
                        try {
                            double otherGrade = Double.parseDouble(otherScore.getGrade());
                            if (otherGrade > grade) {
                                rank++;
                            }
                        } catch (NumberFormatException ignored) {}
                    }
                }

                RankChangeRecord record = new RankChangeRecord(
                        score.getTimeStart(),
                        rank,
                        grade
                );
                rankChanges.add(record);

            } catch (NumberFormatException ignored) {}
        }

        return rankChanges;
    }

    /**
     * 排名变化记录类
     */
    public record RankChangeRecord(String examTime, int rank, double grade) {
    }



}
