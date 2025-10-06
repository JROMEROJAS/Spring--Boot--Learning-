package com.LearningSpring.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController

class HelloWorldRestController {

    @GetMapping("/Hello")
    public String helloWorld() {
        return "Hello World";
    }

}