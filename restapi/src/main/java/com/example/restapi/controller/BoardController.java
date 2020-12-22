package com.example.restapi.controller;

import com.example.restapi.entity.Board;
import com.example.restapi.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RequestMapping("/boards")
@RestController
public class BoardController {

    // private final 필요있나?
    // Autowired는 별로 안좋은 방식인가?
    @Autowired
    private BoardService boardService;

    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE, consumes = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity createBoard() throws Exception{

        Board board = boardService.createBoard();
        URI uri = linkTo(BoardController.class).slash(board.getSequence()).toUri();

        return ResponseEntity.created(uri).body(board);
    }


}
