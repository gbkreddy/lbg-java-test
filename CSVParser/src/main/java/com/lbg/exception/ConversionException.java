package com.lbg.exception;

/**
 * Represents type conversion problem
 */
public class ConversionException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3602099649997101875L;

	public ConversionException(String msg) {
		super(msg);
	}

	public ConversionException(Exception exp) {
		super(exp);
	}
}
