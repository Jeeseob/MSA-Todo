package com.jee.LoginTodo.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/09/28
 */

@Builder
public class UserResponse {
    private Long id;
    private String email;
    private String userName;
}
