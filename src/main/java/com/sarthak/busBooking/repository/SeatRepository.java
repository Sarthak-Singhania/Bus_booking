package com.sarthak.busBooking.repository;

import com.sarthak.busBooking.entity.Bus;
import com.sarthak.busBooking.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
    List<Seat> findByBus(Bus bus);
}