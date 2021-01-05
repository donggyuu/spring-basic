package com.example.restapi.param;

import lombok.Builder;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/*
@Builder와 빌더 패턴 : 객체를 좀더 안전하고 보기 좋게 생성 가능
참고 : https://deepweller.tistory.com/18
 */

/*
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
 */
@Getter
public class CreateBoardParam {

    private String userName;

    @Length(min = 2, max = 300, message = "please input more than {min}, less  than {max}")
    @NotEmpty(message = "please input contents")
    private String content;
}
