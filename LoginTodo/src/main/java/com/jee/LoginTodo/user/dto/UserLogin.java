package com.jee.LoginTodo.user.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/09/28
 */

@Getter
@Setter
@ToString
public class UserLogin {
    private String email;
    private String password;
}
