package com.cg.fda.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)


public class FoodCartIdNotFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	public FoodCartIdNotFoundException() {
		super();
	}
	public FoodCartIdNotFoundException(String msg) {
		super(msg);
	}

}

