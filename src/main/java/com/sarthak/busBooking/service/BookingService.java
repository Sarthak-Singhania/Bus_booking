package com.sarthak.busBooking.service;


import com.sarthak.busBooking.entity.*;
import com.sarthak.busBooking.repository.BookingRepository;
import com.sarthak.busBooking.repository.BusRepository;
import com.sarthak.busBooking.repository.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private BusRepository busRepository;

    public Optional<Booking> getBookingById(int booking_id) {
        return bookingRepository.findById(booking_id);
    }

    public List<Booking> getBookingByUser(User user){
        return bookingRepository.getBookingsByUser(user);
    }

    public String makeBooking(User user, Schedule schedule, Seat seat){
        if (schedule.getBus().getNoOfSeats() == 0){
            return "All seats booked";
        }
        Bus bus = schedule.getBus();
        Booking booking = new Booking();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        booking.setBookingTime(timestamp);
        booking.setSchedule(schedule);
        booking.setUser(user);
        bookingRepository.save(booking);
        seat.setBooked(true);
        seatRepository.save(seat);
        bus.setNoOfSeats(bus.getNoOfSeats()-1);
        busRepository.save(bus);
        return booking.toString();
    }
}
