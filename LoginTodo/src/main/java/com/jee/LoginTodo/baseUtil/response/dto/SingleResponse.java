package com.jee.LoginTodo.baseUtil.response.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/09/28
 */

@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class SingleResponse<T> extends CommonResponse {
    private T data;

    public SingleResponse(T data) {
        this.data = data;
    }
}
