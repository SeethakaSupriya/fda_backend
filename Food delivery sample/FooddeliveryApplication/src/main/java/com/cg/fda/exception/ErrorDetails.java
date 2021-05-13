package com.cg.fda.exception;
import java.util.Date;
/**
 * this class defines the error details when an exception is occured
 * @author supriya
 *
 */



public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;

	public ErrorDetails(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDetails() {
		return details;
	}


}
