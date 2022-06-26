package Jbae.visitor_management.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/07
 */

@Data
public class PersonProgramRequest {
    private LocalDate localDate;

    private Long personId;
    private Long programId;
}
