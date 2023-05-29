package com.sarthak.busBooking.service;


import com.sarthak.busBooking.entity.Bus;
import com.sarthak.busBooking.entity.Driver;
import com.sarthak.busBooking.repository.BusRepository;
import com.sarthak.busBooking.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DriverService {

    @Autowired
    private DriverRepository repository;
    private BusRepository busRepository;

    public Driver getDriver(int id) {
        return repository.findById(id).orElse(null);
    }

    public Driver getDriverByBus(Bus bus) {
        return repository.findByBus(bus);
    }

    public String changeBus(int driverId, int busId) {
        Driver driver = repository.findById(driverId).orElse(null);
        driver.setBus(busRepository.findById(busId).orElse(null));
        return "Driver set";
    }
}
