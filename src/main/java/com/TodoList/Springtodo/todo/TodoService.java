package com.TodoList.Springtodo.todo;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public interface TodoService {
    public Long setTodo(Todo todo);
    public List<Todo> getTodoList();
    public Optional<Todo> getTodo(Long id);
    public void deleteTodo(Long id);
}