package com.example.restapi.service;

import com.example.restapi.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserService {

    // --------------------------------------------------
    // make sample dagta
    // --------------------------------------------------

    // TODO : static 뺴보고 동작 확인
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "Adam", new Date()));
        users.add(new User(2, "Eve", new Date()));
        users.add(new User(3, "Jack", new Date()));
    }


    // --------------------------------------------------
    // method for user
    // --------------------------------------------------
    public List<User> findAll() {
        return users;
    }

    public User findOne(int id) {
        for (User user: users) {
            if (user.getId() == id) {
                return  user;
            }
        }
        return null;
    }

    public User save(User user) {
        // 존재하지 않는 아이디이면 아이디 추가
        if (user.getId() == null) {
            user.setId(++usersCount);
        }

        users.add(user);
        return user;
    }






}
