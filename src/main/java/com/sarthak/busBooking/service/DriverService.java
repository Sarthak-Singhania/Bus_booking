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
    private DriverRepository driverRepository;
    @Autowired
    private BusRepository busRepository;

    public Driver getDriver(int id) {
        return driverRepository.findById(id).orElse(null);
    }

    public Driver getDriverByBus(int busId) {
        Bus bus = busRepository.getReferenceById(busId);
        return driverRepository.findByBus(bus);
    }

    public Driver addDriver(String name, String license, String dateOfBirth, String address, String dateOfJoining, int busId){
        Bus bus=busRepository.getReferenceById(busId);
        Driver driver=new Driver();
        driver.setBus(bus);
        driver.setDriversLicense(license);
        driver.setName(name);
        driver.setAddress(address);
        driver.setDOB(dateOfBirth);
        driver.setDOJ(dateOfJoining);
        driverRepository.save(driver);
        return driver;
    }

    public String changeBus(int driverId, int busId) {
        Driver driver = driverRepository.findById(driverId).orElse(null);
        driver.setBus(busRepository.findById(busId).orElse(null));
        return "Driver set";
    }
}
