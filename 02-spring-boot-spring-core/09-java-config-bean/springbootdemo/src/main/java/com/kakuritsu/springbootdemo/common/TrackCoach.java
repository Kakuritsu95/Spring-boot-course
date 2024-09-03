package com.kakuritsu.springbootdemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout ()  {
        return "Run a hard 5k!";
    }
}

