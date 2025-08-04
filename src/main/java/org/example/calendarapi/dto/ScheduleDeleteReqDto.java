package org.example.calendarapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ScheduleDeleteReqDto {
    @NotBlank
    private String password;
}
