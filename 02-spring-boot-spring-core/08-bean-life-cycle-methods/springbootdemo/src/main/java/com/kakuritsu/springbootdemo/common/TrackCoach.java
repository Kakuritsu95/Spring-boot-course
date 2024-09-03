package com.kakuritsu.springbootdemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component

public class TrackCoach implements Coach{

    //define our init method
    @PostConstruct
    public void doMyStartupStuff(){
    System.out.println("In doMyStartupStuff" + this.getClass().getSimpleName());
    }
    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("In doMyCleanupStuff" +this.getClass().getSimpleName());
    }
    //define our destroy method

    @Override
    public String getDailyWorkout ()  {
        return "Run a hard 5k!";
    }
}

