package Study.TimeCheckProject.member;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Entity
public class TodoList {
    @Id
    private Long id; // 유저 id랑 one to many로 엮어야 되는 데..

    private Long userId;
    // 할일 명
    private String todoItem;
    // 할일 상세 설명
    private String todoDetail;
    // 완료 여부, check box
    private Boolean complete;
    // 마감일
    private LocalDate deadline;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTodoItem() {
        return todoItem;
    }

    public void setTodoItem(String todoItem) {
        this.todoItem = todoItem;
    }

    public String getTodoDetail() {
        return todoDetail;
    }

    public void setTodoDetail(String todoDetail) {
        this.todoDetail = todoDetail;
    }

    public Boolean getComplete() {
        return complete;
    }

    public void setComplete(Boolean complete) {
        this.complete = complete;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
}
