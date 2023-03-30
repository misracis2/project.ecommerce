package com.example.ecommerce.global.exception;

public enum ExceptionMessage {
    OVERLAPPED_ID("이미 존재하는 아이디입니다."),
    NOT_EXIST_ID("존재하지 않는 회원입니다.")
    ;

    private String msg;

    ExceptionMessage(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
