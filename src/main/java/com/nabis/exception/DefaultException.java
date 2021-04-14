package com.nabis.exception;

public class DefaultException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public DefaultException() {
		super("GuestBookDAOException Occurs");
	}
	
	public DefaultException(String msg) {
		super(msg);
	}
}
