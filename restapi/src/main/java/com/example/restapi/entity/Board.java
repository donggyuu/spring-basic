package com.example.restapi.entity;

import com.example.restapi.form.CreateBoardForm;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class Board {

    private Long sequence;

    private String userName;

    private String content;

    private LocalDateTime createdTime;

    // default constructor
    public Board(String userName, String content) {
        this.userName = userName;
        this.content = content;
        this.createdTime = LocalDateTime.now();
    }

    // by user input form
    public Board(CreateBoardForm form) {
        this.userName = form.getUserName();
        this.content = form.getContent();
    }

}
