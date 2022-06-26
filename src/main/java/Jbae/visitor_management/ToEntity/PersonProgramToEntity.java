package Jbae.visitor_management.ToEntity;

import Jbae.visitor_management.dto.PersonProgramRequest;
import Jbae.visitor_management.entity.PersonProgram;
import Jbae.visitor_management.service.PersonService;
import Jbae.visitor_management.service.ProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/08
 */

@Service
public class PersonProgramToEntity {
    @Autowired
    PersonService personService;

    @Autowired
    ProgramService programService;

    public PersonProgram toEntity(PersonProgramRequest request) {
        return  PersonProgram.builder()
                .localDate(request.getLocalDate())
                .person(personService.getPerson(request.getPersonId()))
                .program(programService.getProgram(request.getProgramId()))
                .build();
    }
}
