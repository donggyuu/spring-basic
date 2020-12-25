package com.example.restapi.entity;

import com.example.restapi.param.CreateBoardParam;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


/*
TODO : protected처리 관련 아래 링크를 이해, 포스팅
https://sas-study.tistory.com/366?category=821099

@AllArgsConstructor
@NoArgsConstructor(access = PROTECTED)
*/

@Getter
@Setter
public class Board {


    // TODO : 필드의 annotation의 역할 모아서 포스팅
    // @Id
    // @GeneratedValue(strategy = IDENTITY)
    private Integer sequence;

    private String userName;

    // @Column(length = 300)
    private String content;

    // @Column(updatable = false, nullable = false)
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
