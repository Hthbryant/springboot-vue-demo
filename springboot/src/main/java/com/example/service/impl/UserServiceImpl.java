package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.common.dto.UserRequestDTO;
import com.example.common.dto.UserResponseDTO;
import com.example.common.enums.ErrorEnum;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
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
        BeanUtils.copyProperties(requestDTO, update);
        int result = userMapper.updateById(update);
        if (result < 1) {
            UserResponseDTO userResponseDTO = new UserResponseDTO(ErrorEnum.DB_OPERATE_FAIL);
            return userResponseDTO;
        }
        return new UserResponseDTO();
    }

    @Override
    public UserResponseDTO addUser(UserRequestDTO requestDTO) {
        User user = new User();
        BeanUtils.copyProperties(requestDTO, user);
        int insert = userMapper.insert(user);
        if (insert < 1) {
            return new UserResponseDTO(ErrorEnum.DB_OPERATE_FAIL);
        }
        return new UserResponseDTO();
    }

    @Override
    public UserResponseDTO deleteUser(Integer id) {
        if (id == null) {
            return new UserResponseDTO(ErrorEnum.PARAM_ERROR);
        }
        int i = userMapper.deleteById(id);
        if (i < 1) {
            return new UserResponseDTO(ErrorEnum.DB_OPERATE_FAIL);
        }
        return new UserResponseDTO();
    }

    @Override
    public UserResponseDTO login(UserRequestDTO requestDTO) {
        if (requestDTO == null || StringUtils.isBlank(requestDTO.getUsername()) /*|| StringUtils.isBlank(requestDTO.getPassword())*/) {
            return new UserResponseDTO(ErrorEnum.PARAM_ERROR);
        }
        User select = new User();
        BeanUtils.copyProperties(requestDTO, select);
        //查询用户是否存在
        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, requestDTO.getUsername()));
        if (user == null) {
            log.info("user -{} - not exist!!", requestDTO.getUsername());
            return new UserResponseDTO(ErrorEnum.USER_NOT_EXIST);
        }
        //比对密码
        if (user.getPassword().equals(select.getPassword())) {
            UserResponseDTO responseDTO = new UserResponseDTO(ErrorEnum.SUCCESS);
            responseDTO.setUser(user);
            return responseDTO;
        } else {
            return new UserResponseDTO(ErrorEnum.PASSWORD_WRONG);
        }
    }

    @Override
    public UserResponseDTO register(UserRequestDTO requestDTO) {
        if (requestDTO == null || StringUtils.isBlank(requestDTO.getUsername()) || StringUtils.isBlank(requestDTO.getPassword())) {
            return new UserResponseDTO(ErrorEnum.PARAM_ERROR);
        }
        User select = new User();
        select.setUsername(requestDTO.getUsername());
        //查询用户是否存在
        User user = userMapper.selectOne(Wrappers.<User>lambdaQuery().eq(User::getUsername, requestDTO.getUsername()));
        if (user != null) {
            log.info("user -{} - existed!!", requestDTO.getUsername());
            return new UserResponseDTO(ErrorEnum.USER_EXIST);
        }
        //添加一个用户
        select.setPassword(requestDTO.getPassword());
        int insert = userMapper.insert(select);
        if (insert < 1) {
            log.error("user register failed!!!");
            return new UserResponseDTO(ErrorEnum.DB_OPERATE_FAIL);
        }
        return new UserResponseDTO(ErrorEnum.SUCCESS);
    }
}
