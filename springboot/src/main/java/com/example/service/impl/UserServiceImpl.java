package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.common.dto.UserRequestDTO;
import com.example.common.dto.UserResponseDTO;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserResponseDTO queryUserList() {
        List<User> users = userMapper.selectList(new QueryWrapper<>(null));
        UserResponseDTO response = new UserResponseDTO();
        response.setUserList(users);
        return response;
    }

    @Override
    public UserResponseDTO querUserInfo(UserRequestDTO requestDTO) {
        return null;
    }

    @Override
    public UserResponseDTO updateUser(UserRequestDTO requestDTO) {
        return null;
    }

    @Override
    public UserResponseDTO addUser(UserRequestDTO requestDTO) {
        return null;
    }

    @Override
    public UserResponseDTO deleteUser(UserRequestDTO requestDTO) {
        return null;
    }
}
