package com.kakuritsu.springbootdemo.common;

import org.springframework.stereotype.Component;

@Component
public class FootballCoach implements Coach{
    public FootballCoach(){
        System.out.println("In constructor" + this.getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout ()  {
    return "Shoot 3 penalties.";
    }
}
