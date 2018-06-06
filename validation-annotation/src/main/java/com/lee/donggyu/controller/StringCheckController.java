package com.lee.donggyu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lee.donggyu.annotation.StringCheck;
// import com.lee.donggyu.form.StringCheckForm;


@Controller
public class StringCheckController {
	
	@RequestMapping("/String")
	public String CommentCheck(Model model) {
		
		
		String enterString = "Teststring";
	
		// StringCheckForm stringCheckForm = new StringCheckForm();
		// stringCheckForm.setComment(enterString);
		
		// model.addAttribute(stringCheckForm);
		
		return "StringCheck";
	}

}	
	