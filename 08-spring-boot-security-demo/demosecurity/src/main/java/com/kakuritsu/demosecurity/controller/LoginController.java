package com.kakuritsu.demosecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
    @GetMapping("/showMyLoginPage{error}")
    public String showMyLoginPage(){
        return "fancy-login";
    }
}
