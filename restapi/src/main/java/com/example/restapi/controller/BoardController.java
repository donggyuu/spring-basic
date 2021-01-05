package com.example.restapi.controller;

import com.example.restapi.entity.Board;
import com.example.restapi.param.CreateBoardParam;
import com.example.restapi.param.EditBoardParam;
import com.example.restapi.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RequestMapping("/boards")
@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    /*
    produces : 응답헤더로 반환될 타입을 지정. 이에 따라 응답 body애는 해당 타입이 반환됨
        ex. "produces = MediaTypes.HAL_JSON_VALUE" -> HAL_JSON_VALUE형태가 반환됨
    consumes : 요청해더가 해당 타입인 것만 처리한다. 생략하면 default로 json파일을 받음
     */
    @PostMapping(produces = MediaTypes.HAL_JSON_VALUE)
    /*
    그냥 json파일의 요청을 받을 예정이기 때문에 "consumes = MediaTypes.HAL_JSON_VALUE"는 사용안함
    // @PostMapping(produces = MediaTypes.HAL_JSON_VALUE, consumes = MediaTypes.HAL_JSON_VALUE)

    HAL_JSON_VALUE ?
        Json에 링크 정보를 더한 정도의 개념. 여기선 hateoas를 사용했기에 본 타입을 사용함.
     */
    public ResponseEntity createBoard(@RequestBody @Validated CreateBoardParam param) {

        Board board = boardService.createBoard(param);

        /*
        UserController의 method -> ServletUriComponentsBuilder로 uri작성
        BoardController의 method -> spring-hateoas로 uri작성
         */
        URI uri = getLinkAddress().slash(board.getSequence()).toUri();

        /*
        body에 들어갈 board class와 hateoas를 같이 작성
        추가 요청을 한 상태니, 추가 요청 이외에 get, delete, edit의 api-end-point 링크를 같이 반환
         */
        EntityModel<Board> entityModel = EntityModel.of(
                board,
                getLinkAddress().slash(board.getSequence()).withSelfRel(),
                getLinkAddress().slash(board.getSequence()).withRel("get"),
                getLinkAddress().slash(board.getSequence()).withRel("delete"),
                getLinkAddress().slash(board.getSequence()).withRel("edit"));

        return ResponseEntity.created(uri).body(entityModel);
    }

    /*
    list를 반환할 경우의 hateoas적용, 참고:https://sas-study.tistory.com/369
     */
    @GetMapping(produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity getBoardList() {

        List<Board> boardList = boardService.getBoardList();

        List<EntityModel> entityModelList =  boardList.stream().map(board -> EntityModel.of(
                board,
                getLinkAddress().slash(board.getSequence()).withRel("get"),
                getLinkAddress().slash(board.getSequence()).withRel("delete")))
                .collect(Collectors.toList());

        // 자기자신(getBoardList요청)의 Link정보를 추가한 후 하나의 entityModel로 합침
        CollectionModel entityModel = CollectionModel.of(entityModelList, getLinkAddress().withSelfRel());

        return ResponseEntity.ok(entityModel);
    }


    // hateoas는 사용하지 않음. 고로 굳이 HAL_JSON_VALUE으로 타입을 지정하지 않아도 됨
    @GetMapping(value = "/{sequence}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity getBoard(@PathVariable("sequence") int sequence) {

        Board board = boardService.getBoard(sequence);

        return ResponseEntity.ok(board);
    }

    // hateoas는 사용하지 않음. 고로 굳이 HAL_JSON_VALUE으로 타입을 지정하지 않아도 됨
    @PostMapping(value = "/{sequence}", produces = MediaTypes.HAL_JSON_VALUE)
    public ResponseEntity editBoard(@PathVariable("sequence") int sequence, @RequestBody @Validated EditBoardParam param) {

        Board board = boardService.editBoard(sequence, param);

        if (board == null) {
            /*
            ResponseEntity.notFound().build()도 ok
            body에 무언가 응답을 넣고 싶다면 아래처럼 사용
             */
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);

        } else {
            return ResponseEntity.ok(board);
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


    private WebMvcLinkBuilder getLinkAddress() {
        return linkTo(BoardController.class);
    }

}
