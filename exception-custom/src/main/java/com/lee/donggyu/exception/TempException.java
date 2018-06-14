package com.lee.donggyu.exception;

import org.springframework.ui.Model;

public class TempException extends Exception {
	
	private Model model;
	
	public TempException(int page, Model model) {
		super("Exception number is : "+ Integer.toString(page));
		this.model = model;
	}

	public Model getModel() {
		return model;
	}
}
