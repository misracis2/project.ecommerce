package com.example.ecommerce.global.common;

import com.example.ecommerce.global.exception.ExceptionMessage;

public enum SuccessMessage {

    SING_UP("회원가입을 완료했습니다.")
    ;


    private String msg;

    public String getMsg() {
        return msg;
    }

    SuccessMessage(String msg) {
        this.msg = msg;
    }
}
