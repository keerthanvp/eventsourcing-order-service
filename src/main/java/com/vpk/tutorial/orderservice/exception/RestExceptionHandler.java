package com.vpk.tutorial.orderservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(SerializationException.class)
    public ResponseEntity<ErrorResponse> serializationExceptionHandler(Exception ex, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setRequestURI(request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DaoWriteException.class)
    public ResponseEntity<ErrorResponse> daoWriteExceptionHandler(Exception ex, HttpServletRequest request){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setErrorCode(HttpStatus.EXPECTATION_FAILED.value());
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setRequestURI(request.getRequestURI());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity<ErrorResponse> getErrorResponse(Exception ex, HttpServletRequest request) {
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.BAD_REQUEST.value());
        error.setMessage(ex.getMessage());
        error.setRequestURI(request.getRequestURI());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
