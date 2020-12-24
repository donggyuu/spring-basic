package com.example.restapi.controller;

import com.example.restapi.entity.Board;
import com.example.restapi.param.CreateBoardParam;
import com.example.restapi.param.EditBoardParam;
import com.example.restapi.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.MediaTypes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.time.LocalDateTime;

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
    // TODO : consumes = MediaTypes.HAL_JSON_VALUE 은 반드시 필요한가?
    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    // @PostMapping(produces = MediaTypes.HAL_JSON_VALUE, consumes = MediaTypes.HAL_JSON_VALUE)
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


    @GetMapping(value = "/{sequence}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity getBoard(@PathVariable("sequence") int sequence) throws Exception {

        Board board = boardService.getBoard(sequence);

        if (board == null) {
            return ResponseEntity.notFound().build(); // TODO .build()는 뭐고 언제 붙이는거지?
        } else {
            return ResponseEntity.ok(board);
        }

    }


    @PostMapping(value = "/{sequence}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity editBoard(@PathVariable("sequence") int sequence, @RequestBody EditBoardParam param) {

        Board board = boardService.editBoard(sequence, param);

        if (board == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null); // TODO : ResponseEntity.notFound().build() 랑 뭔차이?
        } else {
            return ResponseEntity.ok(board); // TODO : 어떻게 Json형태로 응답을 주는걸까?
        }

    }


    @DeleteMapping(value = "/{sequence}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity deleteBoard(@PathVariable("sequence") int sequence) {

        Board board = boardService.deleteBoard(sequence);

        if (board == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(board);
    }
}
