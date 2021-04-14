package com.nabis.exception;

public class ApiException extends Exception{
private static final long serialVersionUID = 1L;
private String code;

	public String getCode() {
		return code;
	}

	public ApiException (String code,String msg){
		super(msg);
		this.code = code;
	}
}
