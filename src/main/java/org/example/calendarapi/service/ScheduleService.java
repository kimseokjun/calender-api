package org.example.calendarapi.service;

import org.example.calendarapi.dto.ScheduleRequestDto;
import org.example.calendarapi.dto.ScheduleResponseDto;
import org.example.calendarapi.dto.ScheduleUpdateReqDto;
import org.example.calendarapi.dto.ScheduleUpdateRespDto;
import org.example.calendarapi.entity.Schedule;
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

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
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
        List<Schedule> schedules = scheduleRepository.findByWriter(writer).orElseThrow(() -> new IllegalArgumentException("해당 작성자가 쓴 글이 없습니다."));
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

       schedule.setTitle(scheduleUpdateReqDto.getTitle());
       schedule.setWriter(scheduleUpdateReqDto.getWriter());

       scheduleRepository.save(schedule);

       return new ScheduleUpdateRespDto(schedule.getTitle(),schedule.getContent(),schedule.getWriter(),schedule.getCreatedAt(),schedule.getModifiedAt());
    }

    @Transactional
    public void deleteSchedule(Long id) {
        scheduleRepository.deleteById(id);
    }
}
