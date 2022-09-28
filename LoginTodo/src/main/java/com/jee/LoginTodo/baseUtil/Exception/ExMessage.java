package com.jee.LoginTodo.baseUtil.Exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/09/28
 */

@Getter
@RequiredArgsConstructor
public enum ExMessage {
    EMAIL_ALREADY_EXIST("이미 존재하는 이메일 입니다")
    , EMAIL_PATTERN_INCONSISTENCY("이메일 형식이 올바르지 않습니다.")
    , PASSWORD_PATTERN_INCONSISTENCY("비밀번호는 영문자와 특수문자를 포함하여 8자 이상으로 이뤄져야 합니다.")
    , PASSWORD_INCONSISTENCY("패스워드가 일치하지 않습니다")
    , LOGIN_WRONG_INPUT("아이디 또는 비밀번호를 잘못 입력하셨습니다.")
    ;

    private final String message;
}
