package com.kakuritsu.demosecurity.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String showHome(Model theModel){
     theModel.addAttribute("header","Employee Home Page");

        return "home";
    }
    @GetMapping("/leaders")
    public String showLeadersPage(Model theModel){
        theModel.addAttribute("header","Leaders Home Page");
        return "home";
    }
    @GetMapping("/systems")
    public String showAdminPage(Model theModel){
        theModel.addAttribute("header","Systems Home Page");
        return "home";
    }
    @GetMapping("/authorizationFailed")
    public String showAccessDeniedPage(){
        return "access-denied";
    }

}
