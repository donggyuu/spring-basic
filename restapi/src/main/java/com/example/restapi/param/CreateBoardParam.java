package com.example.restapi.param;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/*
TODO : 아래 annotation은 필수인가에 대한 고민!
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
 */
@Getter
// or AddBoardParam
public class CreateBoardParam {

    private String userName;

    @Length(min = 2, max = 300, message = "please input over than {min}, less  than {max}")
    @NotEmpty(message = "please input contents")
    private String content;

}
