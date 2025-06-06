package com.example.flightapi.controller;

import com.example.flightapi.dto.BaseResponse;
import com.example.flightapi.dto.BookingResponseDTO;
import com.example.flightapi.entity.Booking;
import com.example.flightapi.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/bookings")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<BookingResponseDTO>>> getBookings(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam(defaultValue = "Upcoming") String status) {
        List<BookingResponseDTO> bookings = bookingService.getBookingsByUser(userDetails.getUsername(), status);
        return ResponseEntity.ok(BaseResponse.success(bookings));
    }

    @PostMapping
    public ResponseEntity<BaseResponse<Booking>> createBooking(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam Long flightId) {
        Booking booking = bookingService.createBooking(userDetails.getUsername(), flightId);
        return ResponseEntity.ok(BaseResponse.success(booking));
    }
}
