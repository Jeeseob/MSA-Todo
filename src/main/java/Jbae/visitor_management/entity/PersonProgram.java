package Jbae.visitor_management.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/04
 */

@Data
@Entity
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class PersonProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate localDate;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;
}
