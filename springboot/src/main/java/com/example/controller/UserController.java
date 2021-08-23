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
    public Result queryUserList(HttpServletRequest httpReq,
                                                 HttpServletResponse httpResp,
                                                 @RequestBody UserRequestDTO requestDTO) {
        Result SystemErrorResult = new Result(ErrorEnum.SYSTEM_ERROR);
        try {
            UserResponseDTO userResponseDTO = userService.queryUserList();
            Result result = new Result(userResponseDTO);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return SystemErrorResult;
        }
    }

    @RequestMapping("/info")
    public Result queryUserInfo(HttpServletRequest httpReq,
                                                 HttpServletResponse httpResp,
                                                 @RequestBody UserRequestDTO requestDTO) {
        Result SystemErrorResult = new Result(ErrorEnum.SYSTEM_ERROR);
        try {
            UserResponseDTO userResponseDTO = userService.querUserInfo(requestDTO);
            Result result = new Result(userResponseDTO);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return SystemErrorResult;
        }
    }

    @RequestMapping("/add")
    public Result addUser(HttpServletRequest httpReq,
                                                 HttpServletResponse httpResp,
                                                 @RequestBody UserRequestDTO requestDTO) {
        System.out.println("requestDTO:"+requestDTO);
        Result SystemErrorResult = new Result(ErrorEnum.SYSTEM_ERROR);
        try {
            UserResponseDTO userResponseDTO = userService.addUser(requestDTO);
            Result result = new Result(userResponseDTO);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return SystemErrorResult;
        }
    }

    @RequestMapping("/update")
    public Result updateUser(HttpServletRequest httpReq,
                                                 HttpServletResponse httpResp,
                                                 @RequestBody UserRequestDTO requestDTO) {
        Result SystemErrorResult = new Result(ErrorEnum.SYSTEM_ERROR);
        try {
            UserResponseDTO userResponseDTO = userService.updateUser(requestDTO);
            Result result = new Result(userResponseDTO);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return SystemErrorResult;
        }
    }

    @RequestMapping("/delete")
    public Result delete(HttpServletRequest httpReq,
                                          HttpServletResponse httpResp,
                                          @RequestBody UserRequestDTO requestDTO) {
        Result SystemErrorResult = new Result(ErrorEnum.SYSTEM_ERROR);
        try {
            UserResponseDTO userResponseDTO = userService.deleteUser(requestDTO);
            Result result = new Result(userResponseDTO);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return SystemErrorResult;
        }
    }

}
