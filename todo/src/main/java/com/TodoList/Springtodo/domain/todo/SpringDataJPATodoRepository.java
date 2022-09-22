package com.TodoList.Springtodo.domain.todo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public interface SpringDataJPATodoRepository extends JpaRepository<Todo,Long>, TodoRepository {
    @Override
    Optional<Todo> findById(Long id);
}
