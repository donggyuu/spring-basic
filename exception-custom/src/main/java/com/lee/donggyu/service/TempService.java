package com.lee.donggyu.service;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.lee.donggyu.exception.TempException;

@Service
public class TempService {
	
	public void isPageZero(int page, Model model) throws TempException {
		
		if(page==0) {
			// 예외를 throws 한다.
			throw new TempException(page, model);
		}
	}

}
