package Jbae.visitor_management.service;

import Jbae.visitor_management.ToEntity.PersonProgramToEntity;
import Jbae.visitor_management.dto.PersonProgramRequest;
import Jbae.visitor_management.entity.PersonProgram;
import Jbae.visitor_management.repository.PersonProgramRepository;
import Jbae.visitor_management.repository.PersonProgramRepositoryCustom;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/07
 */

@Service
@Slf4j
public class PersonProgramService {

    @Autowired
    PersonProgramRepository personProgramRepository;

    @Autowired
    PersonProgramRepositoryCustom personProgramRepositoryCustom;

    @Autowired
    PersonProgramToEntity personProgramToEntity;

    public List<PersonProgram> getProgramByPersonId(Long id) {
        List<PersonProgram> personPrograms = personProgramRepositoryCustom.findByPersonId(id);
        log.info(personPrograms.get(0).getProgram().getName());
        return personPrograms;
    }

    public List<PersonProgram> getPersonByProgramId(Long id) {
        return personProgramRepositoryCustom.findByProgramId(id);
    }

    public void setRequest(PersonProgramRequest personProgramRequest) {
        personProgramRepository.save(personProgramToEntity.toEntity(personProgramRequest));
    }
}
