package com.sarthak.busBooking.repository;

import com.sarthak.busBooking.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Integer> {

    List<Route> findBySourceAndDestination(String source, String destination);
}
