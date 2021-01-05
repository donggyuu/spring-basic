package com.example.restapi.param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

/*
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
 */
@Getter
@Setter
public class EditBoardParam {

    @Length(min = 2, max = 300, message = "please input over than {min}, less  than {max}")
    @NotEmpty(message = "please input contents")
    private String content;
}
