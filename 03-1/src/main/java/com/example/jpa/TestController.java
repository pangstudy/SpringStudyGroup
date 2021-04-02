package com.example.jpa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping(value = "/first", method = RequestMethod.GET)
    public void first() {

    }

    @RequestMapping(value = "/hellowworld", method = RequestMethod.GET)
    public String helloWorld() {

        return "hello world";
    }
}
