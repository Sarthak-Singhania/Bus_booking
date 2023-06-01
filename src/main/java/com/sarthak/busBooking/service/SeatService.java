package com.sarthak.busBooking.service;

import com.sarthak.busBooking.entity.Bus;
import com.sarthak.busBooking.entity.Seat;
import com.sarthak.busBooking.repository.BusRepository;
import com.sarthak.busBooking.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private BusRepository busRepository;

    public List<Seat> listSeatsByBus(int busId){
        Bus bus=busRepository.findById(busId).orElse(null);
        return seatRepository.findByBus(bus);
    }
}
