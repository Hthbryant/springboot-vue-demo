package com.example.service;

import com.example.entity.User;

import java.util.List;

public interface UserService {

    List<User> queryUserList();

    User querUserInfo(User user);

    int updateUser(User user);

    int deleteUser(User user);

}
