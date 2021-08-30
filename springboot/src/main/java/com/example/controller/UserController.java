package com.example.controller;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.common.dto.Result;
import com.example.common.dto.UserRequestDTO;
import com.example.common.dto.UserResponseDTO;
import com.example.common.enums.ErrorEnum;
import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Resource
    UserMapper userMapper;

    @GetMapping("/page")
    public Page<User> findPage(@RequestParam Integer currentPage, @RequestParam Integer pageSize, @RequestParam String keyword) {
        Page<User> userPage = userMapper.selectPage(new Page<>(currentPage, pageSize), Wrappers.<User>lambdaQuery().like(User::getUsername, keyword));
        log.info("userPage:{}", userPage);
        return userPage;
    }


    @RequestMapping("/list")
    @Cacheable("userList")
    public Result queryUserList(HttpServletRequest httpReq,
                                HttpServletResponse httpResp,
                                @RequestBody UserRequestDTO requestDTO) {
        log.info("query userList request:{}", requestDTO);
        Result SystemErrorResult = new Result(ErrorEnum.SYSTEM_ERROR);
        try {
            UserResponseDTO userResponseDTO = userService.queryUserList();
            return new Result(userResponseDTO);
        } catch (Exception e) {
            log.error("query userList error:", e);
            return SystemErrorResult;
        }
    }

    @RequestMapping("/info")
    public Result queryUserInfo(HttpServletRequest httpReq,
                                HttpServletResponse httpResp,
                                @RequestBody UserRequestDTO requestDTO) {
        log.info("===query userInfo request:{}", requestDTO);
        Result SystemErrorResult = new Result(ErrorEnum.SYSTEM_ERROR);
        try {
            UserResponseDTO userResponseDTO = userService.querUserInfo(requestDTO);
            return new Result(userResponseDTO);
        } catch (Exception e) {
            log.error("===query userInfo error:", e);
            return SystemErrorResult;
        }
    }

    @RequestMapping("/add")
    @CacheEvict("userList")
    public Result addUser(HttpServletRequest httpReq,
                          HttpServletResponse httpResp,
                          @RequestBody UserRequestDTO requestDTO) {
        log.info("===add user request:{}", requestDTO);
        Result SystemErrorResult = new Result(ErrorEnum.SYSTEM_ERROR);
        try {
            UserResponseDTO userResponseDTO = userService.addUser(requestDTO);
            return new Result(userResponseDTO);
        } catch (Exception e) {
            log.error("===add user error:", e);
            return SystemErrorResult;
        }
    }

    @RequestMapping("/update")
    public Result updateUser(HttpServletRequest httpReq,
                             HttpServletResponse httpResp,
                             @RequestBody UserRequestDTO requestDTO) {
        log.info("update userInfo request:{}", requestDTO);
        Result SystemErrorResult = new Result(ErrorEnum.SYSTEM_ERROR);
        try {
            UserResponseDTO userResponseDTO = userService.updateUser(requestDTO);
            return new Result(userResponseDTO);
        } catch (Exception e) {
            log.error("update userInfo error:", e);
            return SystemErrorResult;
        }
    }

    @RequestMapping("/delete")
    public Result delete(HttpServletRequest httpReq,
                         HttpServletResponse httpResp,
                         @RequestBody UserRequestDTO requestDTO) {
        log.info("delete user request:{}", requestDTO);
        Result SystemErrorResult = new Result(ErrorEnum.SYSTEM_ERROR);
        try {
            UserResponseDTO userResponseDTO = userService.deleteUser(requestDTO);
            return new Result(userResponseDTO);
        } catch (Exception e) {
            log.error("delete user error:", e);
            return SystemErrorResult;
        }
    }

}
