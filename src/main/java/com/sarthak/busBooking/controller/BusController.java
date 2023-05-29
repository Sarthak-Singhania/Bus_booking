package com.sarthak.busBooking.controller;

import com.sarthak.busBooking.entity.Bus;
import com.sarthak.busBooking.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public class BusController {

    @Autowired
    private BusService busService;

    @PostMapping("/addBus")
    public Bus addBus(@RequestBody Map<String, String> busInfo){
        return busService.createBus(busInfo.get("name"), busInfo.get("owner"), Integer.parseInt(busInfo.get("noOfSeats")),busInfo.get("license"));
    }

}
