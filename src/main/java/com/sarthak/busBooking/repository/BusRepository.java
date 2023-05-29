package com.sarthak.busBooking.repository;

import com.sarthak.busBooking.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus, Integer> {
}
