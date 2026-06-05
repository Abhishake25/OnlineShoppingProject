package com.shopping.exception;

public class ShoppingException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ShoppingException() {
		super();
	}
	
	public ShoppingException(String message) {
		super(message);
	}
	
	public ShoppingException(String message,Throwable cause) {
		super(message,cause);
	}
	
	public ShoppingException(Throwable cause) {
		super(cause);
	}
}
