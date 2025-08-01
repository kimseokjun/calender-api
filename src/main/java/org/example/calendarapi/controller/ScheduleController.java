package org.example.calendarapi.controller;

import org.example.calendarapi.dto.*;
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
    @GetMapping("/schedules")   //작성자기반 일정 조회(안쓰면 전체조회)
    public List<ScheduleResponseDto> findByWriter(@RequestParam(required = false) String writer) {
        if(writer==null || writer.isEmpty()){
            return scheduleService.findAll();
        }else{
            return scheduleService.findByWriter(writer);
        }

    }
    @PatchMapping("/schedules/{id}")    //일정 수정
    public ScheduleUpdateRespDto updateSchedule(@PathVariable("id") Long id, @RequestBody ScheduleUpdateReqDto scheduleUpdateReqDto) {
            
        return scheduleService.updateSchedule(id,scheduleUpdateReqDto);
    }
    
    @DeleteMapping("/schedules/{id}")   //일정 삭제
    public void deleteSchedule(@PathVariable("id") Long id, @RequestBody ScheduleDeleteReqDto scheduleDeleteReqDto) {
        System.out.println("확인용 " + scheduleDeleteReqDto.getPassword());
        scheduleService.deleteSchedule(id, scheduleDeleteReqDto);
    }
}
