package com.jee.LoginTodo.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/09/28
 */

@Getter
@Setter
@Builder
@ToString
public class UserSignup {
    private String email;
    private String password1;
    private String password2;
    private String userName;
}
