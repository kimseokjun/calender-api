package org.example.calendarapi.service;

import org.example.calendarapi.dto.ScheduleRequestDto;
import org.example.calendarapi.dto.ScheduleResponseDto;
import org.example.calendarapi.entity.Schedule;
import org.example.calendarapi.respository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
