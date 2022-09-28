package com.jee.LoginTodo.baseUtil.Exception;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/09/28
 */

public class BussinessException extends RuntimeException{
    public BussinessException(ExMessage exMessage) {
        super(exMessage.getMessage());
    }

}
