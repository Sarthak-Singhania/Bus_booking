package com.sarthak.busBooking.repository;

import com.sarthak.busBooking.entity.Route;
import com.sarthak.busBooking.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Integer> {

    List<Schedule> findByRouteAndTravelDateAndStartTime(Route route, LocalDate travelDate, LocalTime startTime);
}
