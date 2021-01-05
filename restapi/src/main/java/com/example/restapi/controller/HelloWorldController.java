package com.example.restapi.controller;

import com.example.restapi.bean.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/*
rest-api의 동작을 확인하는 기본적인 controller
 */
@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "hello world";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {

        // return된 instance는 Jackson에의해 Json형태로 반환된다.
        return new HelloWorldBean("this returned bean instance");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("this returned bean using path variable(name)-> %s", name));
    }

}
