package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public List<User> queryUserList(){
        return userService.queryUserList();
    }

    @RequestMapping("/info")
    public String queryUserInfo(){
        return "";
    }

    @RequestMapping("/add")
    public String addUser(){
        return "";
    }

    @RequestMapping("/update")
    public String updateUser(){
        return "";
    }

    @RequestMapping("/delete")
    public String deleteUser(){
        return "";
    }

}
