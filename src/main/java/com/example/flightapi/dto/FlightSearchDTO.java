package com.example.flightapi.dto;

import lombok.Data;

@Data
public class FlightSearchDTO {
    private String from;
    private String to;
    private String departureDate;
    // 如果需要后续支持往返或者乘客数，可再加字段
}
