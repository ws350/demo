package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:0xOO
 * @Date: 2018/9/26 0026
 * @Time: 14:42
 */

@RestController
@RequestMapping("/User")
public class UserController {

    @Autowired
    private UserService userService;

    //@Autowired
    //private User user;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        return userService.Sel(id).toString();
    }


    @RequestMapping("/addUser")
    public void addUser(@RequestBody User user, HttpServletRequest request){
        userService.addUser(user);
    }

    @RequestMapping("/insertUser")
    public void insertUser(@RequestBody User user, HttpServletRequest request){
        userService.insertUser(user);
    }
}
