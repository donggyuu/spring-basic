package com.example.restapi.service;

import com.example.restapi.entity.Board;
import com.example.restapi.entity.User;
import com.example.restapi.param.CreateBoardParam;
import com.example.restapi.param.EditBoardParam;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// TODO : 아래 annotation이 꼭 필요한가?
// TODO : @Transactional(readOnly = true)
// TODO : @RequiredArgsConstructor
@Service // TODO : @Component와의 정확한 차이는?
public class BoardService {

    // 임시DB 코드 작성 -> 추후 H2나 MySQL로 교체
    private static List<Board> boardList = new ArrayList<>();

    private static int boardSeq = 3;

    static {
        boardList.add(new Board(1, "David", "First Contents", LocalDateTime.now()));
        boardList.add(new Board(2, "Adam", "Second Contents", LocalDateTime.now()));
        boardList.add(new Board(3, "Brian", "Third Contents", LocalDateTime.now()));
    }


    // temp board
    // param으로 처리한 값을 entity객체에 넣는중...
    // @Transactional
    public Board createBoard(CreateBoardParam param) {

        Board board = new Board(param);

        // 추후 JPA로 대체
        board.setSequence(++boardSeq);
        board.setCreatedTime(LocalDateTime.now());
        boardList.add(board);

        return board;
    }


    public List<Board> getBoardList() {
        return boardList;
    }


    public Board getBoard(int sequence) throws EntityNotFoundException {

        for (Board board: boardList) {
            if (board.getSequence() == sequence) {
                return  board;
            }
        }

        // return null 해서 controller에서 200status로 처리도 가능.
        throw new EntityNotFoundException("해당사람이 작성한 게시글이 존재하지 않음");

    }


    /*
    TODO : JPA를 사용할 경우 1차캐시 영역 등 JPA의 동작 원리에 대해서 포스팅하기
    https://sas-study.tistory.com/366?category=821099
     */
    // @Transactional
    public Board editBoard(int sequence, EditBoardParam param) {

        for (Board board: boardList) {
            if (board.getSequence() == sequence) {
                board.setContent(param.getContent());
                return  board;
            }
        }

        return null;
    }


    // @Transactional
    public Board deleteBoard(int sequence) {

        // TODO : Iterator의 개념 및 사용법 정리
        // for문으로도 해결 가능한데 굳이 Iterator를 써야?
        // 아마 remove()로 쉽게 해결하기 위함일듯
        Iterator<Board> boardIterator = boardList.iterator();

        while (boardIterator.hasNext()) {
            Board board = boardIterator.next();
            if (board.getSequence() == sequence) {
                boardIterator.remove();
                return  board;
            }
        }

        return null;
    }


}
