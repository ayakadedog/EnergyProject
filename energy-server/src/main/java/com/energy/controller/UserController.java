package com.energy.controller;

import cn.hutool.crypto.digest.BCrypt;
import com.energy.constant.JwtClaimsConstant;
import com.energy.constant.MessageConstant;
import com.energy.context.BaseContext;
import com.energy.dto.UserLoginDTO;
import com.energy.entity.User;
import com.energy.exception.BaseException;
import com.energy.exception.PasswordErrorException;
import com.energy.properties.JwtProperties;
import com.energy.result.Result;
import com.energy.service.UserService;
import com.energy.utils.JwtUtil;
import com.energy.vo.UserLoginVO;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Result<String> login(@RequestBody UserLoginDTO userLoginDTO, HttpServletRequest request) {
        if (userLoginDTO == null || userLoginDTO.getUsername() == null) {
            return Result.error(MessageConstant.ACCOUNT_NOT_NULL);
        }
        if (userLoginDTO.getPassword() == null) {
            return Result.error(MessageConstant.PASSWORD_NOT_NULL);
        }
        userService.login(userLoginDTO, request);

        return Result.success(MessageConstant.LOGIN_SUCCESS);
    }


    /**
     * 退出
     *
     * @return
     */
    @PostMapping("/logout")
    public Result<String> logout() {
        return Result.success();
    }


}
