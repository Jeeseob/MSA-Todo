package Jbae.visitor_management.dto;

import lombok.Data;
import java.time.LocalDateTime;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/07
 */

@Data
public class PersonProgramRequest {
    private LocalDateTime localDateTime;

    private Long personId;
    private Long programId;
}
