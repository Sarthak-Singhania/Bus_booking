package com.sarthak.busBooking.repository;

import com.sarthak.busBooking.entity.Booking;
import com.sarthak.busBooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> getBookingsByUser(User user);
}
