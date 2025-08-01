package org.example.calendarapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    private Long schedule_id;

    public Comment(String comment, String writer, String password, Long scheduleId) {
        this.comment = comment;
        this.writer = writer;
        this.password = password;
        this.schedule_id = scheduleId;
    }
}
