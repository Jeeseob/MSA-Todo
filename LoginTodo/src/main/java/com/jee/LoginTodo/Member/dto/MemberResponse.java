package com.jee.LoginTodo.Member.dto;

import lombok.Builder;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/09/28
 */

@Builder
public class MemberResponse {
    private Long id;
    private String email;
    private String userName;
}
