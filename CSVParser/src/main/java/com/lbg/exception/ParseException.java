package com.lbg.exception;

/**
 * Represents parser problem
 */
public class ParseException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7577402857640898376L;

	public ParseException(String msg) {
		super(msg);
	}

	public ParseException(Exception exp) {
		super(exp);
	}
}
