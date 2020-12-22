package com.example.restapi.service;

import com.example.restapi.entity.Board;

public class BoardService {

    // temp board
    public Board createBoard() {
        Board sampleBoard = new Board("sampleName", "sampleContents");

        return sampleBoard;
    }
}
