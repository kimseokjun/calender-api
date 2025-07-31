package org.example.calendarapi.controller;

import org.example.calendarapi.dto.ScheduleRequestDto;
import org.example.calendarapi.dto.ScheduleResponseDto;
import org.example.calendarapi.dto.ScheduleUpdateReqDto;
import org.example.calendarapi.dto.ScheduleUpdateRespDto;
import org.example.calendarapi.entity.Schedule;
import org.example.calendarapi.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping("/schedules")//일정 생성
    public ScheduleResponseDto saveSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto) {

        return scheduleService.saveSchedule(scheduleRequestDto);
    }

//    @GetMapping("/schedules/{writer}")
//    public List<Schedule> findByWriter(@PathVariable String writer) {
//        return scheduleService.findByWriter(writer);
//    }
    @GetMapping("/schedules")
    public List<ScheduleResponseDto> findByWriter(@RequestParam(required = false) String writer) {
        if(writer==null || writer.isEmpty()){
            return scheduleService.findAll();
        }else{
            return scheduleService.findByWriter(writer);
        }

    }
    @PatchMapping("/schedules/{id}")
    public ScheduleUpdateRespDto updateSchedule(@PathVariable("id") Long id, @RequestBody ScheduleUpdateReqDto scheduleUpdateReqDto) {
            
        return scheduleService.updateSchedule(id,scheduleUpdateReqDto);
    }
    
    
}
