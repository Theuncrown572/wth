package org.example.springbootmybatis.config;

import org.example.springbootmybatis.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {


    @Bean
    @Conditional({})
    public User user(){

        return new User();
    }
}
