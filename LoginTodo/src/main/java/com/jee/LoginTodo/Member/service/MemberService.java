package com.jee.LoginTodo.Member.service;

import com.jee.LoginTodo.baseUtil.Exception.BussinessException;
import com.jee.LoginTodo.baseUtil.Exception.ExMessage;
import com.jee.LoginTodo.Member.dto.MemberLogin;
import com.jee.LoginTodo.Member.dto.MemberResponse;
import com.jee.LoginTodo.Member.dto.MemberSignup;
import com.jee.LoginTodo.Member.entity.Member;
import com.jee.LoginTodo.Member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Pattern;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/09/28
 */

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void signUp(MemberSignup memberSignup) throws Exception {
        try {
            this.isVaild(memberSignup);
            Member user = Member.builder()
                    .email(memberSignup.getEmail())
                    .password(memberSignup.getPassword1())
                    .userName(memberSignup.getUserName()).build();

            memberRepository.save(user);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public MemberResponse login(MemberLogin memberLogin) {
        Optional<Member> optionalUser = memberRepository.findByEmailAndPassword(memberLogin.getEmail(), memberLogin.getPassword());
        if (optionalUser.isPresent()) {
            return optionalUser.get().toResponse();
        }
        throw new BussinessException(ExMessage.LOGIN_WRONG_INPUT);
    }

    public boolean logout() {
        return true;
    }

    // id, password 기준에 맞춘다.
    private void isVaild(MemberSignup memberSignup) {
        this.isVaildEmail(memberSignup.getEmail());
        this.isVaildPassword(memberSignup.getPassword1(), memberSignup.getPassword2());
    }

    private void isVaildEmail(String email) {
        Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");
        if(!emailPattern.matcher(email).matches()) {
            throw new BussinessException(ExMessage.EMAIL_PATTERN_INCONSISTENCY);
        } else if (memberRepository.findByEmail(email).isPresent()) {
            throw new BussinessException(ExMessage.EMAIL_ALREADY_EXIST);
        }
    }

    private void isVaildPassword(String password1, String password2) {
        Pattern passwordExpression = Pattern.compile("^(?=.*[a-zA-Z])(?=.*\\d)(?=.*\\W).{8,20}$");
        if (!passwordExpression.matcher(password1).matches()) {
            throw new BussinessException(ExMessage.PASSWORD_PATTERN_INCONSISTENCY);
        } else if (!password1.equals(password2)) {
            throw new BussinessException(ExMessage.PASSWORD_INCONSISTENCY);
        }
    }
}
