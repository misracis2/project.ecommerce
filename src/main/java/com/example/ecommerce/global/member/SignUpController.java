package com.example.ecommerce.global.member;

import com.example.ecommerce.global.common.MessageHandler;
import com.example.ecommerce.global.common.SuccessMessage;
import com.example.ecommerce.global.member.model.MemberDto;
import com.example.ecommerce.global.member.service.SignUpService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "sign up")
@RestController
@RequiredArgsConstructor
public class SignUpController {

    private final SignUpService signUpService;

    @ApiOperation(value = "회원가입 API")
    @PostMapping("/signup")
    public MessageHandler signup(@RequestBody @ApiParam(value = "회원 정보") MemberDto.SignUpDto signUpDto) {
        return signUpService.signUp(signUpDto);
    }


}
