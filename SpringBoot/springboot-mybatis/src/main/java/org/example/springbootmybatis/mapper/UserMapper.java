package org.example.springbootmybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.example.springbootmybatis.domain.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}
