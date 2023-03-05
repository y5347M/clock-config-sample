package com.example.clockconfigsample.time;


import com.example.clockconfigsample.config.ClockConfig;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CustomLocalDateTime {

    private static ClockConfig clockConfig;

    public static void setClockConfig(ClockConfig clockConfig) {
        CustomLocalDateTime.clockConfig = clockConfig;
    }

    private CustomLocalDateTime() {}

    public static LocalDateTime customLocalDateTime() {
        return LocalDateTime.now(clockConfig.clock());
    }

    public static LocalDate customLocalDate() {
        return LocalDate.now(clockConfig.clock());
    }

    public static LocalTime customLocalTime() {
        return LocalTime.now(clockConfig.clock());
    }
}
