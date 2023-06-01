package com.sarthak.busBooking.controller;

import com.sarthak.busBooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book")
    public Object book(@RequestBody Map<String, Integer> bookingInfo) {
        return bookingService.makeBooking(bookingInfo.get("user"), bookingInfo.get("schedule"), bookingInfo.get("seat"));
    }
}
