package com.example.service;

import com.example.entity.User;
import com.example.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 15:23
 */
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public User Sel(int id){
        return userMapper.Sel(id);
    }

    public void addUser(User user){
        userMapper.addUser(user);
    }


    public void insertUser(User user){
        userMapper.insertUser(user);
    }
}
