package com.example.restapi.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// TODO: @AllArgsConstructor 등이 필요할까? 어차피 deafult로 만들어질텐데? -> 아래를 참고
// https://dingue.tistory.com/14
public class EditBoardParam {

    private String content;

}
