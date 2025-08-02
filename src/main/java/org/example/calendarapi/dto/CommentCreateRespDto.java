package org.example.calendarapi.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.calendarapi.entity.Comment;

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

    public CommentCreateRespDto(Comment comment) {
        this.comment_id = comment.getComment_id();
        this.schedule_id = comment.getSchedule().getId();
        this.comment = comment.getComment();
        this.writer = comment.getWriter();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }

    @Override
    public String toString() {
        return "CommentCreateRespDto{" +
                "comment_id=" + comment_id +
                ", schedule_id=" + schedule_id +
                ", comment='" + comment + '\'' +
                ", writer='" + writer + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
