package com.lee.donggyu.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.http.HttpStatus;

import com.lee.donggyu.exception.TempException;
import com.lee.donggyu.service.TempService;

@Controller
public class TempController {

	@Autowired
	private TempService TempService;

	@RequestMapping("/temp")
	public String checkExceptionInModel(Model model, @RequestParam(defaultValue = "0") int page) throws TempException {

		String cacheParam = "cacheParamValue";
		model.addAttribute("cacheParam", cacheParam);

		TempService.isPageZero(page, model); // nPage==0 이라면 예외를 발생시킴. 그것을 ExceptionHandler에서 잡음.

		// @ControllerAdvice에 설정한 것들은 status를 잘 반환하는데...

		// 1. 이 구문에서 예외처리를 하는가? >> O
		// 2. status400을 제대로 뱉어내는가? >> X
		// 3. model안에 cache가 제대로 들어있는가? >> O
		// try {
		// TempService.isPageZero(page);
		//
		// return "index";
		//
		// } catch (TempException e) {
		// // resp.setStatus(400);
		//
		// return "exception_test";
		// }

		return "index";
	}

	// 1. 이 함수에서 예외처리를 하는가? >> O
	// 2. status400을 제대로 뱉어내는가? >> O
	// 3. model안에 cache가 제대로 들어있는가? >> X
	// 예외처리시 model은 쓰지 말라고 doc에 나와있으니..
	// 쓴다 하더라도 model은 새로 만들어지는 모델이라 cache없음..
	@ExceptionHandler(TempException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public String failure(TempException e) {
		Model model = e.getModel();
		
		ModelAndView modelAndView = new ModelAndView();
	
		Map<String, Object> map = model.asMap();
	
		// model.asMap().
		
		// for()
		
		
		return "exception";
	}

}
