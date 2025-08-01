package org.example.calendarapi.service;


import org.example.calendarapi.dto.CommentCreateReqDto;
import org.example.calendarapi.dto.CommentCreateRespDto;
import org.example.calendarapi.entity.Comment;
import org.example.calendarapi.respository.CommentRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentCreateRespDto saveComment(Long scheduleid, CommentCreateReqDto commentCreateReqDto) {
        Comment comment = new Comment(commentCreateReqDto.getComment(),
                commentCreateReqDto.getWriter(),
                commentCreateReqDto.getPassword(),
                scheduleid);

        commentRepository.save(comment);

        return new CommentCreateRespDto(comment.getComment_id(),
               comment.getSchedule_id(),
                comment.getComment(),
                comment.getWriter(),
                comment.getCreatedAt(),
                comment.getModifiedAt());
    }
}
