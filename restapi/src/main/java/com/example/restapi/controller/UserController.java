package com.example.restapi.controller;

import com.example.restapi.entity.User;
import com.example.restapi.exception.UserNotFoundException;
import com.example.restapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

/*
user정보를 조회,등록,삭제하는 rest-api
 */
@RestController
public class UserController {

    // @Autowired가 항상 좋은 방법은 아닐 수 있다.
    // https://nocount.tistory.com/173
    @Autowired
    private UserService service;


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.findAll();
    }

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        User user = service.findOne(id);

        if (user == null) {
            throw new UserNotFoundException("id : " + id);
        }

        // return된 instance는 Jackson에의해 Json형태로 반환된다.
        return user;
    }

    @PostMapping("/users")
    public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
        User savedUser = service.save(user);

        /*
        ServletUriComponentsBuilder :
        http요청으로부터 link를 만들기 위해, UriComponentsBuilder에 factory methods를 추가한 class
        (about "factory method" : https://jdm.kr/blog/180)
         */
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()               // mapping으로 들어온 "/users" 를 사용
                .path("/{id}")                      // /users/{id}
                .buildAndExpand(savedUser.getId())  // {id}는 savedUser.getId()
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteById(@PathVariable  int id) {
        User user = service.deleteById(id);

        if (user == null) {
            throw new UserNotFoundException("id : " + id);
        }
    }

}
