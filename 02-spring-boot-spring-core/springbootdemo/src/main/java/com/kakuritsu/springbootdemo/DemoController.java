package com.kakuritsu.springbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private Coach myCoach;
    DemoController (Coach theCoach) {
        this.myCoach = theCoach;
    }
    @GetMapping("/workout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();

    }
}
