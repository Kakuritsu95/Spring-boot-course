package com.kakuritsu.springbootdemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BaseballCoach implements Coach{
    public BaseballCoach(){
        System.out.println("In constructor" + this.getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice.";
    }
}
