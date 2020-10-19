package com.shaan.shoppingcart.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidCustomerTypeException extends RuntimeException {

	public InvalidCustomerTypeException() {
        super("No data was returned for this request");
    }

    public InvalidCustomerTypeException(String message) {
        super(message);
    }

}
