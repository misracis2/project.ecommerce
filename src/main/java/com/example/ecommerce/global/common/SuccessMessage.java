package com.example.ecommerce.global.common;

public enum SuccessMessage {

    SING_UP("회원가입을 완료했습니다."),

    //PRODUCT
    REGISTER_PRODUCT("상품 등록을 완료했습니다.")
    ;


    private String msg;

    public String getMsg() {
        return msg;
    }

    SuccessMessage(String msg) {
        this.msg = msg;
    }
}
