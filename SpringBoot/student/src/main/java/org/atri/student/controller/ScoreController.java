package org.atri.student.controller;

import org.atri.student.entity.Score;
import org.atri.student.service.ScoreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/scores")
public class ScoreController {
    private final ScoreService scoreService;

    public ScoreController(ScoreService scoreService) {
        this.scoreService = scoreService;
    }

    @GetMapping
    public List<Score> list() {
        return scoreService.listAll();
    }

    @GetMapping("/subjects/{subjects}")
    public List<Score> listBySubjects(@PathVariable String subjects) {
        return scoreService.selectBySubjects(subjects);
    }

    @PostMapping
    public ResponseEntity<Score> create(@RequestBody Score score) {
        Score created = scoreService.create(score);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (scoreService.delete(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Score> update(@PathVariable Long id, @RequestBody Score score) {
        Optional<Score> optionalScore = scoreService.update(id, score);
        return optionalScore.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @GetMapping("/subjects/mostProgress/{subjects}")
    public Optional<ScoreService.ImprovementResult> findBestImprovement(@PathVariable String subjects) {
        return scoreService.findBestImprovement(subjects);
    }
    @GetMapping("/subjects/analyzeRankChanges/{number}/{subjects}")
    public List<ScoreService.RankChangeRecord> analyzeRankChanges(@PathVariable String number,@PathVariable String subjects){
        return scoreService.analyzeRankChanges(number,subjects);
    }
    
    /**
     * 获取指定学生在所有科目中的历次考试排名变化
     * @param number 学生编号
     * @return 该学生在所有科目中的排名变化记录
     */
    @GetMapping("/score/rankChanges/{number}")
    public List<ScoreService.RankChangeRecord> getAllRankChangesByStudent(@PathVariable String number) {
        return scoreService.getAllRankChangesByStudent(number);
    }
}
