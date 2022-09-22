package Jbae.visitor_management.dto;

import Jbae.visitor_management.entity.Program;
import lombok.Data;

import java.time.LocalTime;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/04
 */

@Data
public class ProgramRequest {
    private String name;
    private String type;
    private LocalTime startTime;
    private LocalTime endTime;

    public Program toEntity() {
        return Program.builder()
                .name(this.name)
                .type(this.type)
                .startTime(this.startTime)
                .endTime(this.endTime)
                .build();
    }
}
