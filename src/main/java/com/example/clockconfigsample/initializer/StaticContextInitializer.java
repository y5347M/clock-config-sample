package com.example.clockconfigsample.initializer;

import com.example.clockconfigsample.config.ClockConfig;
import com.example.clockconfigsample.time.CustomLocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class StaticContextInitializer {

    @Autowired
    private ClockConfig clockConfig;

    @PostConstruct
    public void init() {
        CustomLocalDateTime.setClockConfig(clockConfig);
    }
}
