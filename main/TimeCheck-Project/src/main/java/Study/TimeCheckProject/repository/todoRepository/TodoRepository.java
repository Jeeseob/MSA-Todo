package Study.TimeCheckProject.repository.todoRepository;

import Study.TimeCheckProject.member.TodoList;

public interface TodoRepository {
    // todolist 설정
    void setTodoList(TodoList todoList);
    // 완료 여부 확인
    void setComplete(Boolean Compete);
    //

    void findById(Long todoListId);

    void findFinished();



}
