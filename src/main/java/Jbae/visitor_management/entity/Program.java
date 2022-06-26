package Jbae.visitor_management.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;
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
public class Program {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String type;
    private LocalTime startTime;
    private LocalTime endTime;


    @OneToMany(mappedBy = "program")
    private List<PersonProgram> personPrograms;
}
