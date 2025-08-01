package org.example.calendarapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
public class CommentCreateRespDto {

    private Long comment_id;
    private Long schedule_id;
    private String comment;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;


}
