package org.example.calendarapi.dto;

import lombok.Getter;
import org.example.calendarapi.entity.Comment;
import org.example.calendarapi.entity.Schedule;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
public class ScheduleWithCommentsRespoDto {
    private Long id;
    private String title;
    private String content;
    private String writer;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    //Comment 반환해야하는 것들만 해서 새로 만듬
    private List<CommentDto> comments;

    public ScheduleWithCommentsRespoDto(Schedule schedule, List<Comment> comments1){
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.content = schedule.getContent();
        this.writer = schedule.getWriter();
        this.createdAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();
        List<CommentDto> cm = new ArrayList<>();
        for (Comment c : comments1) {
            cm.add(new CommentDto(c));
        }
        this.comments = cm;
    }
}
