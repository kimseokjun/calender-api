package org.example.calendarapi.dto;

import lombok.Getter;

import java.time.LocalDateTime;


@Getter
public class ScheduleUpdateRespDto {

    String title;
    String content;
    String writer;
    LocalDateTime createdAt;
    LocalDateTime modifiedAt;


    public ScheduleUpdateRespDto(String title, String content, String writer , LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
