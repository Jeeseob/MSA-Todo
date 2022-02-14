package com.TodoList.Springtodo.todo;

import java.util.List;
import java.util.Optional;

public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Long addTodo(Todo todo) {
        todoRepository.save(todo);
        return todo.getId();
    }

    @Override
    public List<Todo> findTodoList() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<Todo> findTodoById(Long id) {
        return todoRepository.findById(id);
    }

//    public Optional<Todo> findByMemeber(Long memberId) {
//        return todoRepository.findByMember(memberId);
//    }
//
//    public Optional<Todo> findByProgress(Long memberId, Progress progress) {
//        return todoRepository.findByProgress(memberId, progress);
//    }

}
