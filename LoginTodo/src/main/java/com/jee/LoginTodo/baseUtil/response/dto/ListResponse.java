package com.jee.LoginTodo.baseUtil.response.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/09/28
 */

@Getter
@RequiredArgsConstructor
public class ListResponse<T> extends CommonResponse {
    private List<T> dataList;
    private int count;

    public ListResponse(List<T> dataList) {
        this.dataList = dataList;
        this.count = dataList.size();
    }
}
