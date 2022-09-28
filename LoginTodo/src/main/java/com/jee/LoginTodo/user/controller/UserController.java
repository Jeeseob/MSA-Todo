package com.jee.LoginTodo.user.controller;

import com.jee.LoginTodo.baseUtil.response.dto.CommonResponse;
import com.jee.LoginTodo.baseUtil.response.dto.SingleResponse;
import com.jee.LoginTodo.baseUtil.response.service.ResponseService;
import com.jee.LoginTodo.user.dto.UserLogin;
import com.jee.LoginTodo.user.dto.UserResponse;
import com.jee.LoginTodo.user.dto.UserSignup;
import com.jee.LoginTodo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/09/28
 */



@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final ResponseService responseService;
    private final UserService userService;

    @PostMapping("/signUp")
    public CommonResponse signUp(@RequestBody UserSignup userSignup) {
        try {
            log.info("sign in: " + userSignup.getEmail());
            userService.signUp(userSignup);
            return responseService.successResult();
        } catch (Exception e) {
            return responseService.failResult(e.getMessage());
        }
    }

    @PostMapping("/login")
    public CommonResponse login(@RequestBody UserLogin userLogin) {
        try {
            log.info("login: " + userLogin.getEmail());
            return responseService.singleResult(
                    userService.login(userLogin));
        } catch (Exception e) {
            return responseService.failResult(e.getMessage());
        }
    }

    @PostMapping("/logout")
    public CommonResponse logout() {
        try {
            log.info("logout");
            userService.logout();
            return responseService.successResult();
        } catch (Exception e) {
            return responseService.failResult(e.getMessage());
        }
    }
}
