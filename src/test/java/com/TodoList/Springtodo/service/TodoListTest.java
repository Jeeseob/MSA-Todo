package com.TodoList.Springtodo.service;

import com.TodoList.Springtodo.domain.todo.Todo;
import com.TodoList.Springtodo.domain.todo.TodoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class TodoListTest {

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TestEntityManager entityManager;

    String title = "테스트 하기";
    String content = "TDD 테스트하기";

    private Todo addTodo(int num) {
        Todo todo = Todo.builder()
                .title(title + num)
                .content(content + num)
                .build();

        return entityManager.persist(todo);
    }

    List<Todo> savedtodoList = new ArrayList<>();

    @Test
    public void TodoList저장하기() {
        // GIVEN
        for (int i = 0; i < 5; i++) {
            savedtodoList.add(addTodo(i));
        }

        // WHEN
        List<Todo> todoList = todoRepository.findAll();

        // THEN
        Assertions.assertThat(savedtodoList).isEqualTo(todoList);
    }

    @Test
    public void TodoList확인하기() {
        // GIVEN
        for (int i = 1; i < 5; i++) {
            savedtodoList.add(addTodo(i));
        }
        // WHEN
        Optional<Todo> todoOptional = todoRepository.findById(1L);

        // THEN
        System.out.println(todoOptional.get().getTitle());
        Assertions.assertThat(todoOptional.get().getTitle()).isEqualTo(title + 1);
    }
}

