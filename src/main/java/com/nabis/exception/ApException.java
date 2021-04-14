package com.nabis.exception;

public class ApException extends RuntimeException{

	private String code;

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ApException(String code){

		this.code = code;

	}

	public String getCode() {
		return code;
	}


}
