package com.kakuritsu.springbootdemo.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


public class SwimCoach implements Coach{
    public SwimCoach(){
        System.out.println("In constuctor " + this.getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout(){
        return "Swim 1000 meters as a warm up";
    }

}
