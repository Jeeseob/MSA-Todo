package com.jee.LoginTodo.baseUtil.response.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/09/28
 */

@Getter
@RequiredArgsConstructor
public enum CommonResult {
    SUCCESS(1, "성공")
    , FAIL(0, "실패");

    private final int code;
    private final String message;
}
