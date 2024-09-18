package com.kakuritsu.spring_security_jwt.rest;

//import com.kakuritsu.spring_security_jwt.UserMapper.UserMapper;
import com.kakuritsu.spring_security_jwt.dto.UserDTO;


import com.kakuritsu.spring_security_jwt.entities.User;

import com.kakuritsu.spring_security_jwt.service.AuthorityService;
import com.kakuritsu.spring_security_jwt.service.UserService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
   private UserService userService;
    private AuthorityService authService;
    UserController(UserService userService, AuthorityService authService){
        this.userService = userService;
        this.authService = authService;

    }

    @GetMapping("/test")
    public String test (){
        return "WORKS";
    }

 @PostMapping("/users")
    public User createUser(@RequestBody User user){
     user.setPassword("{noop}"+user.getPassword());
     return  userService.createUser(user);


    }

    @GetMapping("/users/{id}")
    public User getById(@PathVariable Long id){
        return userService.findById(id);

//        return UserMapper.toDTO(tempUser);
    }


}
