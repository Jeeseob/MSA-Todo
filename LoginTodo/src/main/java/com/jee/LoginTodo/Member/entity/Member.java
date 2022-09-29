package com.jee.LoginTodo.Member.entity;

import com.jee.LoginTodo.Member.dto.MemberResponse;
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
@RequiredArgsConstructor
@AllArgsConstructor
public class Member {
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

    public MemberResponse toResponse() {
        return MemberResponse.builder()
                .id(this.id)
                .email(this.email)
                .userName(this.userName)
                .build();
    }
}



