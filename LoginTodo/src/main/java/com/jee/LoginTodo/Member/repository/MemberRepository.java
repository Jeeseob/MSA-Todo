package com.jee.LoginTodo.Member.repository;

import com.jee.LoginTodo.Member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/09/28
 */

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmailAndPassword(String email, String password);

    Optional<Member> findByEmail(String Email);
}
