package com.kakuritsu.springbootdemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{

    @Override
    public String getDailyWorkout ()  {
    return "Shoot 3 penalties.";
    }
}
