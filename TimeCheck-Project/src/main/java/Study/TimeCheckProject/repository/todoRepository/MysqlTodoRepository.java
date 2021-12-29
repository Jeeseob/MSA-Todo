package Study.TimeCheckProject.repository.todoRepository;

import Study.TimeCheckProject.member.TodoList;
import Study.TimeCheckProject.member.User;

public class MysqlTodoRepository implements TodoRepository {

    private User user;

    public MysqlTodoRepository(User user) {
        this.user = user;
    }


    @Override
    public void setTodoList(TodoList todoList) {
        // 유저에 todolist 추가할 수 있도록
    }

    @Override
    public void setComplete(Boolean Compete) {

    }

    @Override
    public void findById(Long todoListId) {

    }

    @Override
    public void findFinished() {

    }
}
