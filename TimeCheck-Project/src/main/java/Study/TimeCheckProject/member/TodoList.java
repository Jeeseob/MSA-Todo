package Study.TimeCheckProject.member;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

@Entity
public class TodoList {
    @Id
    private Long id;
    // 할일 명
    private String todoItem;
    // 할일 상세 설명
    private String todoDetail;
    // 완료 여부, check box
    private Boolean complete;
    // 마감일
    private LocalDate deadline;
}
