package com.kakuritsu.springbootdemo.rest;

import com.kakuritsu.springbootdemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoController {
    private Coach myCoach;
//    Constructor injection
    DemoController (Coach theCoach) {
        this.myCoach = theCoach;
    }
//    Setter injection
//    @Autowired
//    void setMyCoach (Coach theCoach){
//        this.myCoach = theCoach;
//    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return this.myCoach.getDailyWorkout();

    }
}
