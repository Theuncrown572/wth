package org.example.springbootmybatis;

import org.example.springbootmybatis.domain.User;
import org.example.springbootmybatis.mapper.UserMapper;
import org.example.springbootmybatis.mapper.UserXmlMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootMybatisApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserXmlMapper userXmlMapper;
//    @Test
//    public void textFindAll() {
//        System.out.println(userMapper.findAll());
//    }
//    @Test
//    public void textFindAll2() {
//        System.out.println(userXmlMapper.findAll());
//    }
    @Test
    public void Select() {
        List<User> list = userMapper.selectList(null);
        for (User user : list) {
            System.out.println(user);
        }
    }
    @Test
    public void Add(){
        User user = new User(null, "1144", "123456");
        int insert = userMapper.insert(user);
        System.out.println(insert);
        System.out.println(user+"插入成功");
    }
    public void Update(){
        User user = new User(5, "1144", "123456");
        int update = userMapper.updateById(user);
        System.out.println(update);
        System.out.println(user+"更新成功");
    }
    public void Delete(){
        int delete = userMapper.deleteById(5);
        System.out.println(delete);
        System.out.println("删除成功");
    }
}
