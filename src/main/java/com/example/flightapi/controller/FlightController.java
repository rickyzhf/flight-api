package com.example.flightapi.controller;

import com.example.flightapi.dto.BaseResponse;
import com.example.flightapi.dto.FlightSearchDTO;
import com.example.flightapi.entity.Flight;
import com.example.flightapi.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/flights")
@RequiredArgsConstructor
public class FlightController {

    private final FlightService flightService;

    @PostMapping("/search")
    public ResponseEntity<BaseResponse<List<Flight>>> searchFlights(@RequestBody FlightSearchDTO searchDTO) {
        List<Flight> flights = flightService.searchFlights(searchDTO);
        return ResponseEntity.ok(BaseResponse.success(flights));
    }
}
