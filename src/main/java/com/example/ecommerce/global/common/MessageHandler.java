package com.example.ecommerce.global.common;

public class MessageHandler {
    private final String msg;

    public MessageHandler(SuccessMessage successMessage) {
        this.msg = successMessage.getMsg();
    }
}
