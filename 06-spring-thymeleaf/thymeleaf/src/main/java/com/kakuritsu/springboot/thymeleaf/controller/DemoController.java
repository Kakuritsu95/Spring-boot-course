package com.kakuritsu.springboot.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/app")
public class DemoController {

    @GetMapping("/hello")
    public String sayHello(Model theModel){
        theModel.addAttribute("theDate", java.time.LocalDateTime.now());
        return "helloworld";
    }
    @GetMapping("show-form")
    public String sendForm(){
        return "form";
    }
    @PostMapping("process-form")
    public String sendHello(Model theModel, @RequestParam("name") String name){

        String theName = name.toUpperCase();
        String result = "Yo! " + theName;

        theModel.addAttribute("shoutTheName",result);
        return "process-form";
    }
}
