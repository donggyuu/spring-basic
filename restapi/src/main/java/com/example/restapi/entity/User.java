package com.example.restapi.entity;

import lombok.Data;
import lombok.Getter;

import java.util.Date;

@Data
public class User {

    private Integer id;

    private String name;

    private Date birthDate;

    public User(Integer id, String name, Date birthDate) {
        // super() # 부모로부터 상속받은 class라면 자동으로 호출되니 쓸 필요 없음
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    // 자동 Override : control+i
    @Override
    public String toString() {
        return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
    }

}
