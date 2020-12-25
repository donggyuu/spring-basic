package com.example.restapi.param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/*
TODO : 아래 annotation은 필수인가에 대한 고민!
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
 */
@Getter
@Setter
// TODO: @AllArgsConstructor 등이 필요할까? 어차피 default로 만들어질텐데? -> 아래를 참고
// https://dingue.tistory.com/14
public class EditBoardParam {

    @Length(min = 2, max = 300, message = "please input over than {min}, less  than {max}")
    @NotEmpty(message = "please input contents")
    private String content;

}
