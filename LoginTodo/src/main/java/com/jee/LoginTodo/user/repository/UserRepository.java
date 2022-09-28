package com.jee.LoginTodo.user.repository;

import com.jee.LoginTodo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/09/28
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByEmail(String Email);
}
