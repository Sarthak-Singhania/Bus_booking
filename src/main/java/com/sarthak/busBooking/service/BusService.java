package com.sarthak.busBooking.service;


import com.sarthak.busBooking.entity.Bus;
import com.sarthak.busBooking.entity.Seat;
import com.sarthak.busBooking.repository.BusRepository;
import com.sarthak.busBooking.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusService {

    @Autowired
    private BusRepository busRepository;
    @Autowired
    private SeatRepository seatRepository;

    public Bus findBus(int busId) {
        return busRepository.getReferenceById(busId);
    }

    public Bus createBus(String name, String owner, int noOfSeats, String license) {
        List<Seat> seats = new ArrayList<>();
        Bus bus = new Bus();
        bus.setNoOfSeats(noOfSeats);
        bus.setName(name);
        bus.setOwner(owner);
        bus.setLicensePlate(license);
        busRepository.save(bus);
        for (int j = 0; j < noOfSeats; j++) {
            Seat seat = new Seat();
            seat.setBooked(false);
            seat.setBus(bus);
            seat.setSeatMeta(j % 2 == 0 ? "aisle" : "window");
            seats.add(seat);
        }
        seatRepository.saveAllAndFlush(seats);
        return bus;
    }
}
