package com.example.clockconfigsample.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.ObjectUtils;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

@Configuration
@Slf4j
public class ClockConfig {

    @Value("${time-travel.specified-time}")
    private String specifiedTime;

    @Bean
    public Clock clock() {
        if(ObjectUtils.isEmpty(specifiedTime)) {
            log.info("Using default clock");
            return Clock.system(ZoneId.of("Asia/Tokyo"));
        } else {
            log.info("Using custom clock: {}", specifiedTime);
            return Clock.fixed(Instant.parse(specifiedTime), ZoneId.of("Asia/Tokyo"));
        }
    }

}
