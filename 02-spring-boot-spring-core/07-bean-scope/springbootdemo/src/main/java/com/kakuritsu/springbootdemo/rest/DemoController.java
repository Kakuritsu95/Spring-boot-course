package com.kakuritsu.springbootdemo.rest;

import com.kakuritsu.springbootdemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class DemoController {
    private final Coach myCoach;
    private final Coach anotherCoach;
//    Constructor injection
    DemoController (@Qualifier("trackCoach") Coach theCoach, @Qualifier("trackCoach") Coach theAnotherCoach) {

        this.myCoach = theCoach;
        this.anotherCoach = theAnotherCoach;

    }
    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return this.myCoach.getDailyWorkout();

    }
    @GetMapping("/check")
    public String checkBeans(){
       return "Comparing beans: myCoach === anotherCoach, "+ (this.myCoach==anotherCoach);
    }
}
