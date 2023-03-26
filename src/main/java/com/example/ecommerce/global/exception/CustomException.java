package com.example.ecommerce.global.exception;

public class CustomException extends  RuntimeException{

    private String msg;

    public CustomException(ExceptionMessage exceptionMessage) {
        this.msg = exceptionMessage.getMsg();
    }

}
