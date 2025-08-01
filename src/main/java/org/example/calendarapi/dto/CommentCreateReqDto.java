package org.example.calendarapi.dto;

import lombok.Getter;

@Getter
public class CommentCreateReqDto {
    private String comment;
    private String writer;
    private String password;

}
