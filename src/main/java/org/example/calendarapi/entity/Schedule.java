package org.example.calendarapi.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;
    private String writer;
    private String password;

    public void setTitle(String title) {
            this.title = title;
    }

    public void setWriter(String writer) {
            this.writer = writer;
    }


    public void setContent(String content) {}

    public Schedule(String title, String content, String writer, String password) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.password = password;
    }

    public void updateSchedule(String title, String writer) {
        if (title != null) {
            this.title = title;
        }
        if (writer != null) {
            this.writer = writer;
        }
    }
}
