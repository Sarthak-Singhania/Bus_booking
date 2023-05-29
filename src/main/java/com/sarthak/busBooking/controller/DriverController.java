package com.sarthak.busBooking.controller;

import com.sarthak.busBooking.entity.Driver;
import com.sarthak.busBooking.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public class DriverController {

    @Autowired
    private DriverService service;

    @GetMapping("/driver/{driverId}")
    public Driver findDriver(@PathVariable int driverId) {
        return service.getDriver(driverId);
    }

//    @GetMapping("/driver/{busId}")
//    public Driver findDriverByBus(@PathVariable int busId){
//        return service.getDriverByBus(busId);
//    }

    @PostMapping("/changeDriver")
    public String changeDriver(@RequestBody Map<String, Integer> details) {
        return service.changeBus(details.get("driverId"), details.get("busId"));
    }
}
