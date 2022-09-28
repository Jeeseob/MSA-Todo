package com.jee.LoginTodo.user.service;

import com.jee.LoginTodo.baseUtil.Exception.BussinessException;
import com.jee.LoginTodo.baseUtil.Exception.ExMessage;
import com.jee.LoginTodo.baseUtil.response.service.ResponseService;
import com.jee.LoginTodo.user.dto.UserLogin;
import com.jee.LoginTodo.user.dto.UserResponse;
import com.jee.LoginTodo.user.dto.UserSignup;
import com.jee.LoginTodo.user.entity.User;
import com.jee.LoginTodo.user.repository.UserRepository;
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
public class UserService {

    private final UserRepository userRepository;

    public void signUp(UserSignup userSignup) throws Exception {
        try {
            this.isVaild(userSignup);
            User user = User.builder()
                    .email(userSignup.getEmail())
                    .password(userSignup.getPassword1())
                    .userName(userSignup.getUserName()).build();

            userRepository.save(user);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public UserResponse login(UserLogin userLogin) {
        Optional<User> optionalUser = userRepository.findByEmailAndPassword(userLogin.getEmail(), userLogin.getPassword());
        if (optionalUser.isPresent()) {
            return optionalUser.get().toResponse();
        }
        throw new BussinessException(ExMessage.LOGIN_WRONG_INPUT);
    }

    public boolean logout() {
        return true;
    }

    // id, password 기준에 맞춘다.
    private void isVaild(UserSignup userSignup) {
        this.isVaildEmail(userSignup.getEmail());
        this.isVaildPassword(userSignup.getPassword1(), userSignup.getPassword2());
    }

    private void isVaildEmail(String email) {
        Pattern emailPattern = Pattern.compile("^(.+)@(.+)$");
        if(!emailPattern.matcher(email).matches()) {
            throw new BussinessException(ExMessage.EMAIL_PATTERN_INCONSISTENCY);
        } else if (userRepository.findByEmail(email).isPresent()) {
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
