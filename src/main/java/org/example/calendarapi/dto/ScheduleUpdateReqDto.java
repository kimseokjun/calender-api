package org.example.calendarapi.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ScheduleUpdateReqDto {
    @NotBlank
    private String title;
    @NotBlank
    private String password;
    @NotBlank
    private String writer;

}


