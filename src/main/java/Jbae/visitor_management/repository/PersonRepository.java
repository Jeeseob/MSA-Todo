package Jbae.visitor_management.repository;

import Jbae.visitor_management.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/04
 */

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
