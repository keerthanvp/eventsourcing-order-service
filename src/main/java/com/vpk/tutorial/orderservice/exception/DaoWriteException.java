package com.vpk.tutorial.orderservice.exception;

import lombok.Getter;

@Getter
public class DaoWriteException extends RuntimeException{
    String exceptionMessage;

    public DaoWriteException(String exceptionMessage){
        super(exceptionMessage);
        this.exceptionMessage = exceptionMessage;
    }

    public DaoWriteException(String exceptionMessage, Exception exception){
        super(exceptionMessage, exception);
        this.exceptionMessage = exceptionMessage;
    }
}
