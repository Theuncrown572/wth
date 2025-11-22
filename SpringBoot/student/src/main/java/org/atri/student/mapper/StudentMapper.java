package org.atri.student.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.atri.student.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
}

