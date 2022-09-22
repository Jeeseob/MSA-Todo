package Jbae.visitor_management.service;

import Jbae.visitor_management.dto.ProgramRequest;
import Jbae.visitor_management.entity.Program;
import Jbae.visitor_management.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/07
 */

@Service
public class ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    public void setRequest(ProgramRequest programRequest) {
        programRepository.save(programRequest.toEntity());
    }

    public Program getProgram(Long id) {
        return programRepository.findById(id).orElseThrow();
    }

    public List<Program> getAllProgram() {
        return programRepository.findAll();
    }

}
