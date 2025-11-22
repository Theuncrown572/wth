package org.example.springbootmybatis.controller;

import org.example.springbootmybatis.domain.User;
import org.example.springbootmybatis.service.ServiceText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private ServiceText serviceText;

    @RequestMapping("/yes")
    public List<User> yes(){
        return serviceText.fun1();
    }
}

