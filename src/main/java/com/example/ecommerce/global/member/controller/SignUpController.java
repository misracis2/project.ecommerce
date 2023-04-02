package com.example.ecommerce.global.member.controller;

import com.example.ecommerce.global.common.MessageHandler;
import com.example.ecommerce.global.member.model.dto.MemberDto;
import com.example.ecommerce.global.member.service.SignUpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "sign up")
@RestController
@RequiredArgsConstructor
@RequestMapping("/signup")
public class SignUpController {

    private final SignUpService signUpService;

    @ApiOperation(value = "customer 회원가입 API")
    @PostMapping("/customer")
    public MessageHandler customerSignup(@RequestBody @ApiParam(value = "customer 회원 정보") MemberDto.SignUpDto signUpDto) {
        return signUpService.customerSignUp(signUpDto);
    }

    @ApiOperation(value = "seller 회원가입 API")
    @PostMapping("/seller")
    public MessageHandler sellerSignup(@RequestBody @ApiParam(value = "customer 회원 정보") MemberDto.SignUpDto signUpDto) {
        return signUpService.sellerSignUp(signUpDto);
    }

}
