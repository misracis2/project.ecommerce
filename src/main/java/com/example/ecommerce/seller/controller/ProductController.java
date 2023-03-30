package com.example.ecommerce.seller.controller;

import com.example.ecommerce.global.common.MessageHandler;
import com.example.ecommerce.seller.model.ProductDto;
import com.example.ecommerce.seller.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/seller")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @ApiOperation(value = "상품 등록")
    @PostMapping("/product")
    public MessageHandler registerProduct(@RequestBody @ApiParam(value = "상품 등록 정보")ProductDto.RegisterDto registerDto){
        return productService.registerProduct(registerDto);
    }
}
