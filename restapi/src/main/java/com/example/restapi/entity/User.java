package com.example.restapi.entity;

import lombok.Data;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class User {

    private Integer id;

    @Size(min = 2, message = "minimum name size is 2")
    private String name;

    @Past // 현재시간보다 과거
    private Date birthDate;

    public User(Integer id, String name, Date birthDate) {
        // super() # 부모로부터 상속받은 class라면 자동으로 호출되니 쓸 필요 없음
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return String.format("User [id=%s, name=%s, birthDate=%s]", id, name, birthDate);
    }

}
