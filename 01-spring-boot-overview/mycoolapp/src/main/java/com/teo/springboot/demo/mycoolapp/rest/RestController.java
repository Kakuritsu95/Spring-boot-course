package com.teo.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    //Inject superHeroes.fast value from application.properties


    @Value("${superHeroes.fast}")
    private String superHero;
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello " + superHero;
    }


}