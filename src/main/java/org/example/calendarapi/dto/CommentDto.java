package org.example.calendarapi.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.calendarapi.entity.Comment;

@AllArgsConstructor
@Getter
public class CommentDto {
    private Long id;
    private String comment;
    private String writer;

    CommentDto(Comment comment) {
        this.id = comment.getComment_id();
        this.comment = comment.getComment();
        this.writer = comment.getWriter();
    }
}
