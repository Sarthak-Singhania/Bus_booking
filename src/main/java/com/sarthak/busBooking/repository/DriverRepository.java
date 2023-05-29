package com.sarthak.busBooking.repository;

import com.sarthak.busBooking.entity.Bus;
import com.sarthak.busBooking.entity.Driver;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DriverRepository extends JpaRepository<Driver, Integer> {
    Driver findByBus(Bus bus);
}
