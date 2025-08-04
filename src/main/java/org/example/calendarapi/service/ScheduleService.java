package org.example.calendarapi.service;

import org.example.calendarapi.dto.*;
import org.example.calendarapi.entity.Comment;
import org.example.calendarapi.entity.Schedule;
import org.example.calendarapi.respository.CommentRepository;
import org.example.calendarapi.respository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    public ScheduleService(ScheduleRepository scheduleRepository, CommentRepository commentRepository) {
        this.scheduleRepository = scheduleRepository;
        this.commentRepository = commentRepository;
    }

    @Transactional
    public ScheduleResponseDto saveSchedule(ScheduleRequestDto scheduleRequestDto) {

        Schedule schedule = new Schedule(scheduleRequestDto.getTitle(),
                scheduleRequestDto.getContent(),
                scheduleRequestDto.getWriter(),
                scheduleRequestDto.getPassword());

        Schedule savedschedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(
                savedschedule.getTitle(),
                savedschedule.getContent(),
                savedschedule.getWriter(),
                savedschedule.getCreatedAt(),
                savedschedule.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleResponseDto> scheduleResponseDtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            scheduleResponseDtos.add(new ScheduleResponseDto(schedule.getTitle(), schedule.getContent(), schedule.getWriter(), schedule.getCreatedAt(), schedule.getModifiedAt()));
        }
        return scheduleResponseDtos;
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponseDto> findByWriter(String writer) {
        List<Schedule> schedules = scheduleRepository.findByWriter(writer);
        List<ScheduleResponseDto> scheduleResponseDtos = new ArrayList<>();
        for(Schedule schedule : schedules){
            scheduleResponseDtos.add(new ScheduleResponseDto(schedule.getTitle(),schedule.getContent(),schedule.getWriter(),schedule.getCreatedAt(),schedule.getModifiedAt()));
        }
        scheduleResponseDtos.sort((a, b) -> b.getModifiedAt().compareTo(a.getModifiedAt())); // 수정일 기준으로 내림차순
        return scheduleResponseDtos;
    }

    @Transactional
    public ScheduleUpdateRespDto updateSchedule(Long id,ScheduleUpdateReqDto scheduleUpdateReqDto) {
       Schedule schedule = scheduleRepository.findById(id)
               .orElseThrow(()-> new NoSuchElementException("해당 일정이 존재하지 않습니다."));
        String checkpassword = schedule.getPassword();
        schedule.updateSchedule(scheduleUpdateReqDto.getTitle(),scheduleUpdateReqDto.getWriter());
        validatePassword(scheduleUpdateReqDto.getPassword(), checkpassword);

        scheduleRepository.save(schedule);

       return new ScheduleUpdateRespDto(schedule.getTitle(),schedule.getContent(),schedule.getWriter(),schedule.getCreatedAt(),schedule.getModifiedAt());
    }

    @Transactional
    public void deleteSchedule(Long id, ScheduleDeleteReqDto scheduleDeleteReqDto) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("해당 일정이 존재하지 않습니다."));

        validatePassword(scheduleDeleteReqDto.getPassword(), schedule.getPassword());//비밀번호 체크 메서드
        scheduleRepository.deleteById(id);
    }

    @Transactional
    public ScheduleWithCommentsRespoDto getScheduleWithComments(Long id){
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(()-> new NoSuchElementException("해당 일정이 존재하지 않습니다."));
        System.out.println("schedule = " + schedule);
        List<Comment> comments = commentRepository.findBySchedule(schedule);

        return new ScheduleWithCommentsRespoDto(schedule,comments);

    }


    private void validatePassword(String inputPassword, String actualPassword) {
        if (!actualPassword.equals(inputPassword)) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }
    }
}
