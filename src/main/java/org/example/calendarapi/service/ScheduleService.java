package org.example.calendarapi.service;

import org.example.calendarapi.dto.ScheduleRequestDto;
import org.example.calendarapi.dto.ScheduleResponseDto;
import org.example.calendarapi.entity.Schedule;
import org.example.calendarapi.respository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Transactional
    public ScheduleResponseDto save(ScheduleRequestDto scheduleRequestDto) {

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

    public List<ScheduleResponseDto> findAll() {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleResponseDto> scheduleResponseDtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            scheduleResponseDtos.add(new ScheduleResponseDto(schedule.getTitle(), schedule.getContent(), schedule.getWriter(), schedule.getCreatedAt(), schedule.getModifiedAt()));
        }
        return scheduleResponseDtos;
    }

    public List<ScheduleResponseDto> findByWriter(String writer) {
        List<Schedule> schedules = scheduleRepository.findByWriter(writer);
        List<ScheduleResponseDto> scheduleResponseDtos = new ArrayList<>();
        for(Schedule schedule : schedules){
            scheduleResponseDtos.add(new ScheduleResponseDto(schedule.getTitle(),schedule.getContent(),schedule.getWriter(),schedule.getCreatedAt(),schedule.getModifiedAt()));
        }
        scheduleResponseDtos.sort((a, b) -> b.getModifiedAt().compareTo(a.getModifiedAt())); // 수정일 기준으로 내림차순
        return scheduleResponseDtos;
    }

}
