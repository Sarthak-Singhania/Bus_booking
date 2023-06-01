package com.sarthak.busBooking.controller;


import com.sarthak.busBooking.entity.Schedule;
import com.sarthak.busBooking.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @PostMapping("/create")
    public Schedule createSchedule(@RequestBody Map<String, String> scheduleInfo){
        return scheduleService.createSchedule(
                Integer.parseInt(scheduleInfo.get("routeId")),
                Integer.parseInt(scheduleInfo.get("busId")),
                LocalTime.parse(scheduleInfo.get("start")),
                LocalTime.parse(scheduleInfo.get("end")),
                LocalDate.parse(scheduleInfo.get("date"))
        );
    }

    @GetMapping("/getSchedule")
    public List<Schedule> listSchedules(@RequestParam("source") String source, @RequestParam("destination") String destination, @RequestParam("time") String time, @RequestParam("date") String date){
        return scheduleService.getSchedulesByRoute(source, destination, LocalDate.parse(date));
    }
}
