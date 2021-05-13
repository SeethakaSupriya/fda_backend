package com.cg.fda.exception;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
/**
 * this class defines the global exception handling
 * @author supriya
 *
 */
@ControllerAdvice


public class GlobalExceptionHandler {
	/**
	 * this method gives the error details when a ProductIdNotFoundException is thrown
	 * @param ex- object of CustomerNotFoundException
	 * @param request-object of WebRequest
	 * @return error details and http status
	 */
	@ExceptionHandler(FoodCartIdNotFoundException.class)
	public ResponseEntity<?> resourceNotFoundException(FoodCartIdNotFoundException ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	/**
	 * this method gives the error details when an Exception is thrown
	 * @param ex- object of an Exception
	 * @param request-object of WebRequest
	 * @return error details and http status
	 */

	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}



}
