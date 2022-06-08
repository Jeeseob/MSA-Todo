package Jbae.visitor_management.entity;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/04
 */

@Data
@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String organization;
    private String position;

    private String remark;

    @OneToMany(mappedBy = "person", fetch = FetchType.LAZY)
    private Set<PersonProgram> personPrograms = new HashSet<>();
}
