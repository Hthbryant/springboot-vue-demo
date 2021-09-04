package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
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
    public Page<User> findPage(@RequestParam(defaultValue = "1") Integer currentPage,
                               @RequestParam(defaultValue = "5") Integer pageSize,
                               @RequestParam(defaultValue = "") String keyword) {
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if(StringUtils.isNotBlank(keyword)){
            wrapper.like(User::getNickName, keyword);
        }
        Page<User> userPage = userMapper.selectPage(new Page<>(currentPage, pageSize), wrapper);
        log.info("userPage:{}", JSON.toJSONString(userPage));
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
    @CacheEvict("userList")
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

    @RequestMapping("/delete/{id}")
    @CacheEvict("userList")
    public Result delete(HttpServletRequest httpReq,
                         HttpServletResponse httpResp,
                         @PathVariable Integer id) {
        log.info("delete user request id:{}", id);
        Result SystemErrorResult = new Result(ErrorEnum.SYSTEM_ERROR);
        try {
            UserResponseDTO userResponseDTO = userService.deleteUser(id);
            return new Result(userResponseDTO);
        } catch (Exception e) {
            log.error("delete user error:", e);
            return SystemErrorResult;
        }
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Result userLogin(HttpServletRequest httpReq,
                         HttpServletResponse httpResp,
                         @RequestBody UserRequestDTO requestDTO) {
        log.info("user login request :{}", requestDTO.getUsername());
        Result SystemErrorResult = new Result(ErrorEnum.SYSTEM_ERROR);
        try {
            UserResponseDTO userResponseDTO = userService.login(requestDTO);
            return new Result(userResponseDTO);
        } catch (Exception e) {
            log.error("user login error:", e);
            return SystemErrorResult;
        }
    }

}
