package com.example.flightapi.repository;

import com.example.flightapi.entity.Booking;
import com.example.flightapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByUserAndStatus(User user, String status);
}
