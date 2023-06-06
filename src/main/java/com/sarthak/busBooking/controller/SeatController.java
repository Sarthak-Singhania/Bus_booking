package com.sarthak.busBooking.controller;


import com.sarthak.busBooking.entity.Seat;
import com.sarthak.busBooking.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seat")
public class SeatController {

    @Autowired
    private SeatService seatService;

    @GetMapping
    public List<Seat> listSeats(@RequestParam("busId") int busId) {
        return seatService.listSeatsByBus(busId);
    }
}
