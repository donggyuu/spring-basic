package com.example.restapi.service;

import com.example.restapi.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
/*
User를 get, post하는 service class
UserResourceController와 연관
 */
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


    public  User deleteById(int id) {
        Iterator<User> it = users.iterator();

        while (it.hasNext()) {
            User user = it.next();
            if (user.getId() == id) {
                it.remove();
                return  user; // 꼭 안필요한듯?
            }
        }

        return  null;
    }

}
