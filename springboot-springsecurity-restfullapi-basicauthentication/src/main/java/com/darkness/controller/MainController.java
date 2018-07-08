package com.darkness.controller;

import com.darkness.entity.Greeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping(value = "/user")
    public ResponseEntity<Greeting> getGreetingUser() {
        Greeting greetingUser = new Greeting(1, "Hello User");
        return new ResponseEntity<>(greetingUser, HttpStatus.OK);
    }

    @GetMapping(value = "/admin")
    public ResponseEntity<Greeting> getGreetingAdmin() {
        Greeting greetingAdmin = new Greeting(1, "Hello Admin");
        return new ResponseEntity<>(greetingAdmin, HttpStatus.OK);
    }
}
