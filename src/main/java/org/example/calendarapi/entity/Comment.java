package org.example.calendarapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Comment extends BaseEntity{

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long comment_id;
    private String comment;
    private String writer;
    private String password;


    @ManyToOne  //게시글 하나에 댓글이 여러개가 달릴수 있음.
    @JoinColumn(name ="schedule_id")
    private Schedule schedule;

    public Comment(String comment, String writer, String password, Schedule schedule) {
        this.comment = comment;
        this.writer = writer;
        this.password = password;
        this.schedule = schedule;
    }

}
