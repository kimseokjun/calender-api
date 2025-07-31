package org.example.calendarapi.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private String title;
    private String content;
    private String writer;
    private String password;
}
