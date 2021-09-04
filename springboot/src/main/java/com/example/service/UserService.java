package com.example.service;

import com.example.common.dto.UserRequestDTO;
import com.example.common.dto.UserResponseDTO;

public interface UserService {

    UserResponseDTO queryUserList();

    UserResponseDTO querUserInfo(UserRequestDTO requestDTO);

    UserResponseDTO updateUser(UserRequestDTO requestDTO);

    UserResponseDTO addUser(UserRequestDTO requestDTO);

    UserResponseDTO deleteUser(Integer id);

    /**
     * 用户登录
     * @param requestDTO
     * @return
     */
    UserResponseDTO login(UserRequestDTO requestDTO);

}
