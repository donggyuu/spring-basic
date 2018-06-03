package com.lee.donggyu.form;

import java.io.Serializable;

import com.lee.donggyu.annotation.StringCheck;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StringCheckForm implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@StringCheck(message = "not good comment check")
    private String Comment;
}
