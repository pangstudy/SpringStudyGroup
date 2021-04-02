package com.example.jpa;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Test2Controller {

    @GetMapping("/hello-api")
    public String helloApi() {
        return "hello api";
    }
}
