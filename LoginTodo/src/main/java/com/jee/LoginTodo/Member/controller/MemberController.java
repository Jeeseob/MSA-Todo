package com.jee.LoginTodo.Member.controller;

import com.jee.LoginTodo.baseUtil.response.dto.CommonResponse;
import com.jee.LoginTodo.baseUtil.response.service.ResponseService;
import com.jee.LoginTodo.Member.dto.MemberLogin;
import com.jee.LoginTodo.Member.dto.MemberSignup;
import com.jee.LoginTodo.Member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/09/28
 */



@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class MemberController {

    private final ResponseService responseService;
    private final MemberService memberService;

    @PostMapping("/signUp")
    public CommonResponse signUp(@RequestBody MemberSignup memberSignup) {
        try {
            log.info("sign in: " + memberSignup.getEmail());
            memberService.signUp(memberSignup);
            return responseService.successResult();
        } catch (Exception e) {
            return responseService.failResult(e.getMessage());
        }
    }

    @PostMapping("/login")
    public CommonResponse login(@RequestBody MemberLogin memberLogin) {
        try {
            log.info("login: " + memberLogin.getEmail());
            return responseService.singleResult(
                    memberService.login(memberLogin));
        } catch (Exception e) {
            return responseService.failResult(e.getMessage());
        }
    }

    @PostMapping("/logout")
    public CommonResponse logout() {
        try {
            log.info("logout");
            memberService.logout();
            return responseService.successResult();
        } catch (Exception e) {
            return responseService.failResult(e.getMessage());
        }
    }
}
