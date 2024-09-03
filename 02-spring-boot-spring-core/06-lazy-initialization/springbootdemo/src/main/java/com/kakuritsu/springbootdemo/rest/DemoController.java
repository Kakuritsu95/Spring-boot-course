package com.kakuritsu.springbootdemo.rest;

import com.kakuritsu.springbootdemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoController {
    private final Coach myCoach;
//    Constructor injection
    DemoController (@Qualifier("trackCoach") Coach theCoach) {
        System.out.println("In constructor" + this.getClass().getSimpleName());
        this.myCoach = theCoach;
    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return this.myCoach.getDailyWorkout();

    }
}
