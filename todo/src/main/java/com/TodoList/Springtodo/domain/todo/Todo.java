package com.TodoList.Springtodo.domain.todo;

import com.TodoList.Springtodo.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Todo extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) //DB가 PK를 알아서 생성.
    private Long id; // 데이터 id (pk)
    //private Long memberId; // 유저 id (fk)

    private String title; // 제목
    private String content; // 내용
    private Progress progress; // 진행 여부(BEFORESTART, PROCEEDING, FINISH)
    //private Date dueDate; // 마감기한

    @Builder
    public Todo(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.progress = Progress.BEFORESTART;
    }

    // 데이터 수정시 사용되는 logic
    public Boolean todoUpdate(Long id, Todo todo) {
        if(id == todo.getId()) {
            this.title = todo.getTitle();
            this.content = todo.getContent();
            this.progress = todo.getProgress();
            return true;
        }
        return false;
    }
}
