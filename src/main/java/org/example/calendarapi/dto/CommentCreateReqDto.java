package org.example.calendarapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import org.example.calendarapi.entity.Comment;
import org.example.calendarapi.entity.Schedule;

@Getter
public class CommentCreateReqDto {
    @NotBlank
    private String comment;
    @NotBlank
    private String writer;
    private String password;

    public Comment toEntity(Schedule schedule) {
        return new Comment(this.comment, this.writer, this.password, schedule);
    }
}
