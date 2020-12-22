package com.example.restapi.entity;

import com.example.restapi.param.CreateBoardParam;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Board {

    private Integer sequence;

    private String userName;

    private String content;

    private LocalDateTime createdTime;

    // default constructor
    public Board(Integer sequence, String userName, String content, LocalDateTime createdTime) {
        this.sequence = sequence;
        this.userName = userName;
        this.content = content;
        this.createdTime = LocalDateTime.now();
    }

    // by user input form
    public Board(CreateBoardParam param) {
        this.userName = param.getUserName();
        this.content = param.getContent();
    }

}
