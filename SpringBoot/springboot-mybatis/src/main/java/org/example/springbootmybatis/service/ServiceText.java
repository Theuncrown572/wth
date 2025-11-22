package org.example.springbootmybatis.service;

import org.example.springbootmybatis.domain.User;
import org.example.springbootmybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceText {
    @Autowired
    private UserMapper userMapper;

    public List<User> fun1() {

        User u = new User(null, "wangwu", "123456");
        userMapper.insert(u);

        return userMapper.selectList(null);

    }
}


