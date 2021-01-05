package com.example.restapi.service;

import com.example.restapi.entity.Board;
import com.example.restapi.param.CreateBoardParam;
import com.example.restapi.param.EditBoardParam;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
 */
@Service
public class BoardService {

    // --------------------------------------------------
    // DB대용으로 test data를 설정
    private static List<Board> boardList = new ArrayList<>();

    private static int boardSeq = 3;

    static {
        boardList.add(new Board(1, "David", "First Contents", LocalDateTime.now()));
        boardList.add(new Board(2, "Adam", "Second Contents", LocalDateTime.now()));
        boardList.add(new Board(3, "Brian", "Third Contents", LocalDateTime.now()));
    }
    // --------------------------------------------------


    // @Transactional // 추후 DB연동을 한다면 사용
    public Board createBoard(CreateBoardParam param) {

        Board board = new Board(param);

        // 추후 JPA등으로 대체 가능
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

        // return-null 한 후 controller에서 200status로 처리도 가능. 개발자의 취향.
        throw new EntityNotFoundException("해당사람이 작성한 게시글이 존재하지 않음");
    }

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
