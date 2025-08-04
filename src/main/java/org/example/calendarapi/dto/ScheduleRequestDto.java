package org.example.calendarapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

@Getter
public class ScheduleRequestDto {

    @NotBlank
    private String title;
    @NotBlank
    private String content;
    private String writer;
    private String password;
}
