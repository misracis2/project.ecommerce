package com.example.ecommerce.global.common;

import lombok.Getter;

@Getter
public class MessageHandler {
    private final String msg;

    public MessageHandler(SuccessMessage successMessage) {
        this.msg = successMessage.getMsg();
    }
}
