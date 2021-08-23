package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.example.common.dto.UserRequestDTO;
import com.example.common.dto.UserResponseDTO;
import com.example.common.enums.ErrorEnum;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.BeanUtils;
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
        User user = userMapper.selectById(requestDTO.getId());
        UserResponseDTO response = new UserResponseDTO();
        response.setUser(user);
        return response;
    }

    @Override
    public UserResponseDTO updateUser(UserRequestDTO requestDTO) {
        User update = new User();
        BeanUtils.copyProperties(requestDTO,update);
        int result = userMapper.update(update, new UpdateWrapper<>(update));
        if(result < 1){
            UserResponseDTO userResponseDTO = new UserResponseDTO(ErrorEnum.DB_OPERATE_FAIL);
            return userResponseDTO;
        }
        return new UserResponseDTO();
    }

    @Override
    public UserResponseDTO addUser(UserRequestDTO requestDTO) {
        User user = new User();
        BeanUtils.copyProperties(requestDTO,user);
        int insert = userMapper.insert(user);
        if(insert < 1){
            return new UserResponseDTO(ErrorEnum.DB_OPERATE_FAIL);
        }
        return new UserResponseDTO();
    }

    @Override
    public UserResponseDTO deleteUser(UserRequestDTO requestDTO) {
        int i = userMapper.deleteById(requestDTO.getId());
        if(i < 1){
            return new UserResponseDTO(ErrorEnum.DB_OPERATE_FAIL);
        }
        return new UserResponseDTO();
    }
}
