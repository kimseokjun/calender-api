package org.example.calendarapi.controller;

import org.example.calendarapi.dto.ScheduleRequestDto;
import org.example.calendarapi.dto.ScheduleResponseDto;
import org.example.calendarapi.service.ScheduleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/schedules")//일정 생성
    public ScheduleResponseDto save(@RequestBody ScheduleRequestDto scheduleRequestDto) {

        return scheduleService.save(scheduleRequestDto);
    }
}
