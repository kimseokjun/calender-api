package org.example.calendarapi.controller;


import org.example.calendarapi.dto.CommentCreateReqDto;
import org.example.calendarapi.dto.CommentCreateRespDto;
import org.example.calendarapi.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/schedules/{scheduleid}")
public class CommentController {


    private final CommentService commentService;
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/comments")
    public ResponseEntity<CommentCreateRespDto> saveComment(@PathVariable Long scheduleid, @RequestBody CommentCreateReqDto commentCreateReqDto) {

        CommentCreateRespDto commentCreateRespDto = commentService.saveComment(scheduleid, commentCreateReqDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(commentCreateRespDto);
    }
}
