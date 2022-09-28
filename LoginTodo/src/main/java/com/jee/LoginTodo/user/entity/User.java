package com.jee.LoginTodo.user.entity;

import com.jee.LoginTodo.user.dto.UserResponse;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/09/28
 */

@Entity
@Getter
@Setter
@Builder
@ToString
@RequiredArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;
    private String password;
    private String userName;

    @CreatedDate
    private LocalDateTime createAt;

    @LastModifiedDate
    private LocalDateTime updateAt;

    public UserResponse toResponse() {
        return UserResponse.builder()
                .id(this.id)
                .email(this.email)
                .userName(this.userName)
                .build();
    }
}



