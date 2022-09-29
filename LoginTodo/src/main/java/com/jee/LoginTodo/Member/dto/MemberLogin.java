package com.jee.LoginTodo.Member.dto;

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
public class MemberLogin {
    private String email;
    private String password;
}
