package Study.TimeCheckProject.repository.todoRepository;

import Study.TimeCheckProject.member.TodoList;
import Study.TimeCheckProject.member.User;

import java.util.ArrayList;

public class MysqlTodoRepository implements TodoRepository {

    private ArrayList<TodoList> todoLists;
    private Long userId;

    public MysqlTodoRepository(User user) {
        this.userId = user.getId();
    }


    @Override
    public void setTodoList(TodoList todoList) {
        // 유저에 todolist 추가할 수 있도록
        todoList.setUserId(userId);
        todoLists.add(todoList);
    }

    @Override
    public void setComplete(Boolean Compete) {
       // id가 있어야 찾을 듯, 무엇으로 찾을지 적용
       // 인덱스 수정 필요
       todoLists.get(0).setComplete(Compete);
    }

    @Override
    public void findById(Long todoListId) {

    }

    @Override
    public void findFinished() {

    }
}
