package Study.TimeCheckProject.member;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    private String token;
//    private ArrayList<TimeCheck> timeChecks;
//    private ArrayList<TodoList> todoLists;
//    private ArrayList<CompltedTodoList> compltedTodoLists;
}
