package com.example.restapi.entity;

import com.example.restapi.param.CreateBoardParam;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/*
참고: lombok의 실무 사용법
    https://www.popit.kr/%EC%8B%A4%EB%AC%B4%EC%97%90%EC%84%9C-lombok-%EC%82%AC%EC%9A%A9%EB%B2%95/

"access = PROTECTED"에 대해서
    JPA에서는 프록시를 생성을 위해서 기본 생성자를 반드시 하나를 생성해야함.
    이때 접근 권한이 protected로 하여 굳이 외부에서 생성을 열어두지 않도록 함(안전성 증가)

---------------------------------------------------------------------------------

** 롬복 생성자 관련 개념 정리 **
@NoArgsConstructor         // 파라미터가 없는 기본 생성자를 생성
@RequiredArgsConstructor   // final이나 @NonNull인 필드 값만 파라미터로 받는 생성자를 생성
@AllArgsConstructor        // 모든 필드 값을 파라미터로 받는 생성자를 생성
public class User {
  private Long id;
  @NonNull
  private String username;
  @NonNull
  private String password;
  private int[] scores;
}
↓   ↓   ↓   ↓   ↓
User user1 = new User();
User user2 = new User("dale", "1234");
User user3 = new User(1L, "dale", "1234", null);
*/

// @AllArgsConstructor
// @NoArgsConstructor(access = PROTECTED)
@Getter
@Setter
public class Board {

    private Integer sequence;

    private String userName;

    private String content;

    private LocalDateTime createdTime;

    /*
    @AllArgsConstructor를 사용한다면 생략해도 됨
     */
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
