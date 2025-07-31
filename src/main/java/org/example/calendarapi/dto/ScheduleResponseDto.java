package org.example.calendarapi.dto;

import lombok.Getter;


import java.time.LocalDateTime;

@Getter
public class ScheduleResponseDto {

    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


    public ScheduleResponseDto(String title, String content, String writer , LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
