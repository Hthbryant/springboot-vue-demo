package com.example.controller;

import com.example.common.dto.Result;
import com.example.common.dto.UserRequestDTO;
import com.example.common.dto.UserResponseDTO;
import com.example.common.enums.ErrorEnum;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public Result<UserResponseDTO> queryUserList(HttpServletRequest httpReq,
                                                 HttpServletResponse httpResp,
                                                 @RequestBody UserRequestDTO requestDTO) {
        Result<UserResponseDTO> SystemErrorResult = new Result<>(ErrorEnum.SYSTEM_ERROR);
        Result<UserResponseDTO> result = new Result<>();
        try {
            UserResponseDTO userResponseDTO = userService.queryUserList();
            result.setData(userResponseDTO);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return SystemErrorResult;
        }
    }

    @RequestMapping("/info")
    public Result<UserResponseDTO> queryUserInfo(HttpServletRequest httpReq,
                                                 HttpServletResponse httpResp,
                                                 @RequestBody UserRequestDTO requestDTO) {
        Result<UserResponseDTO> SystemErrorResult = new Result<UserResponseDTO>(ErrorEnum.SYSTEM_ERROR);
        Result<UserResponseDTO> result = new Result<UserResponseDTO>();
        try {
            UserResponseDTO userResponseDTO = userService.querUserInfo(requestDTO);
            result.setData(userResponseDTO);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return SystemErrorResult;
        }
    }

    @RequestMapping("/add")
    public Result<UserResponseDTO> addUser(HttpServletRequest httpReq,
                                                 HttpServletResponse httpResp,
                                                 @RequestBody UserRequestDTO requestDTO) {
        Result<UserResponseDTO> SystemErrorResult = new Result<UserResponseDTO>(ErrorEnum.SYSTEM_ERROR);
        Result<UserResponseDTO> result = new Result<UserResponseDTO>();
        try {
            UserResponseDTO userResponseDTO = userService.addUser(requestDTO);
            result.setData(userResponseDTO);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return SystemErrorResult;
        }
    }

    @RequestMapping("/update")
    public Result<UserResponseDTO> updateUser(HttpServletRequest httpReq,
                                                 HttpServletResponse httpResp,
                                                 @RequestBody UserRequestDTO requestDTO) {
        Result<UserResponseDTO> SystemErrorResult = new Result<UserResponseDTO>(ErrorEnum.SYSTEM_ERROR);
        Result<UserResponseDTO> result = new Result<UserResponseDTO>();
        try {
            UserResponseDTO userResponseDTO = userService.updateUser(requestDTO);
            result.setData(userResponseDTO);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return SystemErrorResult;
        }
    }

    @RequestMapping("/delete")
    public Result<UserResponseDTO> delete(HttpServletRequest httpReq,
                                          HttpServletResponse httpResp,
                                          @RequestBody UserRequestDTO requestDTO) {
        Result<UserResponseDTO> SystemErrorResult = new Result<UserResponseDTO>(ErrorEnum.SYSTEM_ERROR);
        Result<UserResponseDTO> result = new Result<UserResponseDTO>();
        try {
            UserResponseDTO userResponseDTO = userService.deleteUser(requestDTO);
            result.setData(userResponseDTO);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return SystemErrorResult;
        }
    }

}
