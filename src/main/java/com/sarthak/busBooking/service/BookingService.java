package com.sarthak.busBooking.service;


import com.sarthak.busBooking.entity.*;
import com.sarthak.busBooking.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
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
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;

    @PersistenceContext
    private EntityManager entityManager;

    public Optional<Booking> getBookingById(int booking_id) {
        return bookingRepository.findById(booking_id);
    }

    public List<Booking> getBookingByUser(User user) {
        return bookingRepository.getBookingsByUser(user);
    }

    @Transactional(rollbackFor = Exception.class)
    public Object makeBooking(int userId, int scheduleId, int seatId) throws Exception {
        Schedule schedule = scheduleRepository.getReferenceById(scheduleId);
        Seat seat = seatRepository.getReferenceById(seatId);
        User user = userRepository.getReferenceById(userId);
        if (seat.isBooked()){
            return "The seat is already booked!!!";
        }
        if (schedule.getBus().getNoOfSeats() == 0) {
            return "All seats booked";
        }
        Bus bus = schedule.getBus();
        entityManager.lock(seat, LockModeType.PESSIMISTIC_WRITE);
        entityManager.lock(bus, LockModeType.PESSIMISTIC_WRITE);
        Booking booking = new Booking();
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        booking.setBookingTime(timestamp);
        booking.setSchedule(schedule);
        booking.setUser(user);
        booking.setSeat(seat);
        bookingRepository.save(booking);
        seat.setBooked(true);
        seatRepository.save(seat);
        bus.setNoOfSeats(bus.getNoOfSeats() - 1);
        busRepository.save(bus);
        return booking;
    }
}
