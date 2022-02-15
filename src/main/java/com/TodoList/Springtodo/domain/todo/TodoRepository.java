package com.TodoList.Springtodo.domain.todo;

import com.TodoList.Springtodo.domain.todo.Todo;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TodoRepository {

    Todo save(Todo todo);

    Optional<Todo> findById(Long id);
    List<Todo> findAll();

    void deleteById(Long id);

//    Optional<Todo> findByMember(Long memberId);
//    Optional<Todo> findByProgress(Long memberId,Progress progress);

}
