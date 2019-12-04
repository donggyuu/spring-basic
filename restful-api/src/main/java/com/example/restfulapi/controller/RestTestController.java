package com.example.restfulapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {

    @RequestMapping("/restTest")
    public String restTest(@RequestParam String str) {
        return str + " : complete rest test!!";
    }

}
