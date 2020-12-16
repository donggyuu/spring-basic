package com.example.restapi.controller;

import com.example.restapi.entity.User;
import com.example.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResourceController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id) {
        return  service.findOne(id);
    }

    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = service.save(user);

        // URI이 header를 통해서 반환됨
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest() // Mapping으로 들어온 /users 를 쓰겠다.
                .path("/{id}") // id를 뒤에 붙이면 /users/{id}
                .buildAndExpand(savedUser.getId()) // 그 아이디는 savedUser.getId()의 id임
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
