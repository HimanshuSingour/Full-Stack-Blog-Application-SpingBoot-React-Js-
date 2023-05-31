package com.himmu.blog.Expections;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.himmu.blog.dto.ApiResponse;

@ControllerAdvice
class GlobalExpectionhandler {
	
	@ExceptionHandler(ResourseNotFoundExceptions.class)
	public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourseNotFoundExceptions ex){
		
		String message = ex.getMessage();
		ApiResponse apiResponse = new ApiResponse();
		return new ResponseEntity<ApiResponse>(HttpStatus.NOT_FOUND);
		
	}

}
