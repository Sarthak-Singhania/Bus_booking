package com.sarthak.busBooking.service;


import com.sarthak.busBooking.entity.Bus;
import com.sarthak.busBooking.entity.Route;
import com.sarthak.busBooking.entity.Schedule;
import com.sarthak.busBooking.repository.BusRepository;
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
    @Autowired
    private BusRepository busRepository;

    public List<Schedule> getSchedulesByRoute(String source, String destination, LocalDate date) {
        List<Route> routes = routeRepository.findBySourceAndDestination(source, destination);
        List<Schedule> schedules = new ArrayList<>();
        routes.forEach((e) -> {
            schedules.addAll(scheduleRepository.findByRouteAndTravelDate(e, date));
        });
        return schedules;
    }

    public Schedule createSchedule(int routeId, int busId, LocalTime start, LocalTime end, LocalDate date){
        Bus bus=busRepository.getReferenceById(busId);
        Route route=routeRepository.getReferenceById(routeId);
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
