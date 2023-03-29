package com.example.ecommerce.seller.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

public class ProductDto {

    @Getter
    public static class RegisterDto{
        @ApiModelProperty(value = "제목", required = true)
        private String title;

        @ApiModelProperty(value = "제목")
        private String content;

        @ApiModelProperty(value = "제목", required = true)
        private int price;

        @ApiModelProperty(value = "제목", required = true)
        private int stock;

    }
}
