package Jbae.visitor_management.dto;

import Jbae.visitor_management.entity.Person;
import lombok.Data;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/04
 */

@Data
public class PersonRequest {
    private String name;
    private String organization;
    private String position;
    private String remark;

    public Person toEntity() {
        return Person.builder()
                .name(this.name)
                .organization(this.organization)
                .position(this.position)
                .remark(this.remark)
                .build();
    }
}
