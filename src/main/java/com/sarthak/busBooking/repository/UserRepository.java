package com.sarthak.busBooking.repository;

import com.sarthak.busBooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
