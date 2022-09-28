package com.jee.LoginTodo.baseUtil.response.dto;

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
public class CommonResponse {
    private int code;
    private String message;
}
