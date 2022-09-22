package com.TodoList.Springtodo.service.todo;

import com.TodoList.Springtodo.domain.todo.Todo;
import com.TodoList.Springtodo.domain.todo.TodoRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;

    public TodoServiceImpl(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Long setTodo(Todo todo) {
        todoRepository.save(todo);
        return todo.getId();
    }

    @Override
    public List<Todo> getTodoList() {
        return todoRepository.findAll();
    }

    @Override
    public Optional<Todo> getTodo(Long id) {
        return todoRepository.findById(id);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }

//    public Optional<Todo> findByMemeber(Long memberId) {
//        return todoRepository.findByMember(memberId);
//    }
//
//    public Optional<Todo> findByProgress(Long memberId, Progress progress) {
//        return todoRepository.findByProgress(memberId, progress);
//    }

}
