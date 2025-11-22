package org.atri.student.service;

import org.atri.student.entity.Student;
import org.atri.student.mapper.StudentMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentMapper studentMapper;

    public StudentService(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    /**
     * 查询全部学生。
     */
    public List<Student> listAll() {
        return studentMapper.selectList(null);
    }

    /**
     * 根据主键查询学生。
     */
    public Optional<Student> getById(Long id) {
        return Optional.ofNullable(studentMapper.selectById(id));
    }

    /**
     * 新增学生，返回带主键的对象。
     */
    @Transactional
    public Student create(Student student) {
        studentMapper.insert(student);
        return student;
    }

    /**
     * 更新指定学生，存在则返回更新后的对象。
     */
    @Transactional
    public Optional<Student> update(Long id, Student student) {
        Student existing = studentMapper.selectById(id);
        if (existing == null) {
            return Optional.empty();
        }
        existing.setName(student.getName());
        existing.setSubjects(student.getSubjects());
        existing.setGrade(student.getGrade());
        existing.setSex(student.getSex());
        existing.setSid(student.getSid());
        existing.setAddress(student.getAddress());
        existing.setIDNum(student.getIDNum());
        existing.setPhone(student.getPhone());
        existing.setZone(student.getZone());
        studentMapper.updateById(existing);
        return Optional.of(existing);
    }

    /**
     * 删除指定学生，返回是否成功。
     */
    @Transactional
    public boolean delete(Long id) {
        return studentMapper.deleteById(id) > 0;
    }
}

