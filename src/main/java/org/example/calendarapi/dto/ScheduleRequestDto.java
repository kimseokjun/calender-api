package org.example.calendarapi.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    String title;
    String content;
    String writer;
    String password;
}
