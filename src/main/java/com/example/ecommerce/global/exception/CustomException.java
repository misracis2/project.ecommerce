package com.example.ecommerce.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomException extends  RuntimeException{

    private String msg;

    public CustomException(ExceptionMessage exceptionMessage) {
        this.msg = exceptionMessage.getMsg();
    }

}
