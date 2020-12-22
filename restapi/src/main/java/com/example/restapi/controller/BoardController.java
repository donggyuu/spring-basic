package com.example.restapi.controller;

import com.example.restapi.entity.Board;
import com.example.restapi.param.CreateBoardParam;
import com.example.restapi.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RequestMapping("/boards")
@RestController
public class BoardController {

    // private final 필요있나?
    // Autowired는 별로 안좋은 방식인가?
    @Autowired
    private BoardService boardService;

    // TODO : validation처리 필요
    // TODO : Hateoas 사용 결정 필요
    // TODO : produces, consumes에 따른 postman의 415에러 해결하기
    //@PostMapping(produces = MediaTypes.HAL_JSON_VALUE, consumes = MediaTypes.HAL_JSON_VALUE)
    @PostMapping
    public ResponseEntity createBoard(@RequestBody CreateBoardParam param) throws Exception {

        Board board = boardService.createBoard(param);

        // TODO : UserResourceController의 방식과 비교해서 작성
        URI uri = linkTo(BoardController.class).slash(board.getSequence()).toUri();

        return ResponseEntity.created(uri).body(board);
    }


    // TODO : Hateoas 사용 결정 필요
    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity getBoardList() throws Exception {
        return ResponseEntity.ok(boardService.getBoardList());
    }

}
