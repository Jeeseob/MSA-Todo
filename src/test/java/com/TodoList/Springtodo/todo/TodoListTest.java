package com.TodoList.Springtodo.todo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

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
    public void getTodoListTest() {
        // GIVEN
        for (int i = 0; i < 5; i++) {
            savedtodoList.add(addTodo(i));
        }

        // WHEN
        List<Todo> todoList = todoRepository.findAll();

        // THEN
        Assertions.assertThat(savedtodoList).isEqualTo(todoList);
    }

}

