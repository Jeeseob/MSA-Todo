package Jbae.visitor_management.service;

import Jbae.visitor_management.dto.PersonRequest;
import Jbae.visitor_management.entity.Person;
import Jbae.visitor_management.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/04
 */

@Service
public class PersonService {

    @Autowired
    PersonRepository personRepository;

    public void setRequest(PersonRequest personRequest) {
        personRepository.save(personRequest.toEntity());
    }

    public Person getPerson(Long id) {
        return personRepository.findById(id).orElseThrow();
    }

    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

}
