package com.example.clockconfigsample.controller;

import com.example.clockconfigsample.time.CustomLocalDateTime;
import lombok.Builder;
import lombok.Data;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


@RestController
@RequestMapping("/api/datetime")
public class DatetimeController {

    @Data
    @Builder
    public static class Response {
        private LocalDateTime localDateTime;
        private LocalDate localDate;
        private LocalTime localTime;
    }

    @GetMapping
    public Response getCurrentDatetime() {
        return Response.builder()
                .localDateTime(CustomLocalDateTime.customLocalDateTime())
                .localDate(CustomLocalDateTime.customLocalDate())
                .localTime(CustomLocalDateTime.customLocalTime())
                .build();
    }
}