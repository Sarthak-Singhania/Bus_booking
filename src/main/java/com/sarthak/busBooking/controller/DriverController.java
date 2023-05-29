package com.sarthak.busBooking.controller;

import com.sarthak.busBooking.entity.Driver;
import com.sarthak.busBooking.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/driver")
public class DriverController {

    @Autowired
    private DriverService service;

    @GetMapping("/findDriver/{driverId}")
    public Driver findDriver(@PathVariable int driverId) {
        return service.getDriver(driverId);
    }

    @PostMapping("/registerDriver")
    public Driver addDriver(@RequestBody Map<String, String> driverInfo){
        return service.addDriver(driverInfo.get("name"), driverInfo.get("license"),driverInfo.get("DOB"),driverInfo.get("address"),driverInfo.get("DOJ"), Integer.parseInt(driverInfo.get("busId")));
    }

    @PostMapping("/changeDriver")
    public String changeDriver(@RequestBody Map<String, Integer> details) {
        return service.changeBus(details.get("driverId"), details.get("busId"));
    }

    @GetMapping("/findDriverByBus/{busId}")
    public Driver findDriverByBusId(@PathVariable int busId){
        return service.getDriverByBus(busId);
    }
}
