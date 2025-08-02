package org.example.calendarapi.service;


import org.example.calendarapi.dto.CommentCreateReqDto;
import org.example.calendarapi.dto.CommentCreateRespDto;
import org.example.calendarapi.entity.Comment;
import org.example.calendarapi.entity.Schedule;
import org.example.calendarapi.respository.CommentRepository;
import org.example.calendarapi.respository.ScheduleRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {


    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    public CommentService(ScheduleRepository scheduleRepository, CommentRepository commentRepository) {
        this.scheduleRepository = scheduleRepository;
        this.commentRepository = commentRepository;
    }

    public CommentCreateRespDto saveComment(Long scheduleid, CommentCreateReqDto commentCreateReqDto) {
        Schedule schedule = scheduleRepository.findById(scheduleid).orElseThrow(() -> new IllegalArgumentException("해당 일정이 없습니다."));

        Comment comment = new Comment(commentCreateReqDto.getComment(),
                commentCreateReqDto.getWriter(),
                commentCreateReqDto.getPassword(),
                schedule);

        commentRepository.save(comment);

        return new CommentCreateRespDto(comment.getComment_id(),
                comment.getSchedule().getId(),
                comment.getComment(),
                comment.getWriter(),
                comment.getCreatedAt(),
                comment.getModifiedAt());
    }
}
