package com.ratingms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFOundException.class)
    public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFOundException ex){
        String message = ex.getMessage();
        ApiResponse response = new ApiResponse();
        response.setMessage(message);
        response.setSuccess(false);
        response.setStatus(HttpStatus.NOT_FOUND);
        return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
    }
}
