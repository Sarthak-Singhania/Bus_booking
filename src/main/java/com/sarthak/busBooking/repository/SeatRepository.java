package com.sarthak.busBooking.repository;

import com.sarthak.busBooking.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Integer> {
}
