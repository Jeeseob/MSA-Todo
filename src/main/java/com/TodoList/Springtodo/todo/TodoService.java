package com.TodoList.Springtodo.todo;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface TodoService {
    public Long addTodo(Todo todo);
    public List<Todo> findTodoList();
    public Optional<Todo> findTodoById(Long id);
}