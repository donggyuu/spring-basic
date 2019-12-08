package com.example.restfulapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Author {

    @Id
    @GeneratedValue
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    public String toString() {
        return "Author [firstName=" + firstName +", lastName=" + lastName + "]";
    }
}