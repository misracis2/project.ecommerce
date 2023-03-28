package com.example.ecommerce.global.member.service;

import com.example.ecommerce.global.exception.CustomException;
import com.example.ecommerce.global.exception.ExceptionMessage;
import com.example.ecommerce.global.member.SignUpRepository;
import com.example.ecommerce.global.member.model.MemberDto;
import com.example.ecommerce.global.member.model.MemberRole;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
//@Import({BCryptPasswordEncoder.class, SignUpRepository.class, SignUpService.class})
class SignUpServiceTest {

    @Autowired
    private SignUpService signUpService;

    @Test
    public void test(){
        System.out.println("hello");
    }


    @Test
    @DisplayName("sign up 메소드")
    void signUpTest() throws CustomException{
        MemberDto.SignUpDto signUpDto = new MemberDto.SignUpDto();
        signUpDto.setMemberId("hello");
        signUpDto.setPassword("1234");
        signUpDto.setMemberRole(MemberRole.CUSTOMER);
        Assertions.assertEquals(new CustomException(ExceptionMessage.OVERLAPPED_ID), signUpService.signUp(signUpDto));
    }

}