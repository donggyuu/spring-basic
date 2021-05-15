package com.example.redirect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/affiliate")
public class RedirectController {

    @RequestMapping(method = RequestMethod.GET, value = "/{id:^[0-9]{1,9}$}")
    public String redirectBase(@PathVariable Integer id) {

        return "redirect:http://www.naver.com";
    }

}
