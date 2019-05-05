package com.han.helloservice.controller;

import com.han.helloservice.mapper.UserMapper;
import com.han.helloservice.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mapper")
public class MapperController {

    @Autowired
    UserMapper userMapper;


    @RequestMapping("/insertUser")
    public String insertUser() {
        User user = new User();
        long id = Double.doubleToLongBits(Math.random() * 1000f);
        user.setId(Long.valueOf(id).intValue());
        int i = 1 / 0;
        user.setName("jack");
        userMapper.insert(user);
        return "insert test";
    }
}
