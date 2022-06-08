package Jbae.visitor_management.repository;

import Jbae.visitor_management.entity.PersonProgram;
import Jbae.visitor_management.entity.QPerson;
import Jbae.visitor_management.entity.QPersonProgram;
import Jbae.visitor_management.entity.QProgram;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author : Jeeseob
 * @CreateAt : 2022/06/08
 */

@Repository
@RequiredArgsConstructor
public class PersonProgramRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;

    public List<PersonProgram> findByPersonId(Long id) {
        QPersonProgram qPersonProgram = QPersonProgram.personProgram;
        QPerson qPerson = QPerson.person;
        QProgram qProgram = QProgram.program;
        return jpaQueryFactory
                .selectFrom(qPersonProgram)
                .innerJoin(qPersonProgram.person, qPerson).fetchJoin()
                .innerJoin(qPersonProgram.program, qProgram).fetchJoin()
                .where(qPersonProgram.person.id.eq(id))
                .fetch();
    }

    public List<PersonProgram> findByProgramId(Long id) {
        QPersonProgram qPersonProgram = QPersonProgram.personProgram;
        QPerson qPerson = QPerson.person;
        QProgram qProgram = QProgram.program;
        return jpaQueryFactory.selectFrom(qPersonProgram)
                .innerJoin(qPersonProgram.person, qPerson).fetchJoin()
                .innerJoin(qPersonProgram.program, qProgram).fetchJoin()
                .where(qPersonProgram.program.id.eq(id))
                .fetch();
    }
}
