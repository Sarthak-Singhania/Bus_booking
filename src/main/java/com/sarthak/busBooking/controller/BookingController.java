package com.sarthak.busBooking.controller;

import com.sarthak.busBooking.entity.Booking;
import com.sarthak.busBooking.entity.Schedule;
import com.sarthak.busBooking.entity.Seat;
import com.sarthak.busBooking.entity.User;
import com.sarthak.busBooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public String book(@RequestBody Map<String, Object> bookingInfo){
        return bookingService.makeBooking((User) bookingInfo.get("user"), (Schedule) bookingInfo.get("schedule"), (Seat) bookingInfo.get("seat"));
    }
}
