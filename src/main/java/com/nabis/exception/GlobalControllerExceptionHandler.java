package com.nabis.exception;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import micro.core.vo.Response;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

	@ExceptionHandler(SQLException.class)
	@ResponseBody
	public ResponseEntity<?> handleSQLException(HttpServletRequest request, Exception ex){

		Response res = new Response("0001", "데이터 베이스 오류");
		return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
	}


	@ExceptionHandler(CommonException.class)
	@ResponseBody
	public ResponseEntity<?> handleCommonException(HttpServletRequest request, Exception ex){

		Response res = new Response("0001", "공통 오류");
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@ExceptionHandler(ApException.class)
	@ResponseBody
	public ResponseEntity<?> handleApException(HttpServletRequest request, ApException ex){

		Response res = new Response(ex.getCode(), "AP 오류");
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@ExceptionHandler(UserException.class)
	@ResponseBody
	public ResponseEntity<?> handleUserException(HttpServletRequest request, UserException ex){

		Response res = new Response("0001", ex.getMessage());
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

	@ExceptionHandler(ApiException.class)
	@ResponseBody
	public ResponseEntity<?> handleUserException(HttpServletRequest request, ApiException ex){

		Response res = new Response(ex.getCode(), ex.getMessage());
		return new ResponseEntity<>(res, HttpStatus.OK);
	}

}