package com.sarthak.busBooking.service;


import com.sarthak.busBooking.entity.Bus;
import com.sarthak.busBooking.entity.Route;
import com.sarthak.busBooking.entity.Schedule;
import com.sarthak.busBooking.repository.RouteRepository;
import com.sarthak.busBooking.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private RouteRepository routeRepository;

    public List<Schedule> getSchedulesByRoute(String source, String destination, LocalTime time, LocalDate date) {
        List<Route> routes = routeRepository.findBySourceAndDestination(source, destination);
        List<Schedule> schedules = new ArrayList<>();
        routes.forEach((e) -> {
            schedules.addAll(scheduleRepository.findByRouteAndTravelDateAndStartTime(e, date, time));
        });
        return schedules;
    }

    public Schedule createSchedule(Route route, Bus bus, LocalTime start, LocalTime end, LocalDate date){
        Schedule schedule=new Schedule();
        schedule.setBus(bus);
        schedule.setRoute(route);
        schedule.setStartTime(start);
        schedule.setEndTime(end);
        schedule.setTravelDate(date);
        scheduleRepository.save(schedule);
        return schedule;
    }
}
