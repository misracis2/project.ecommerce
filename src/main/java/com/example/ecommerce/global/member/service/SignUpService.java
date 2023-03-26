package com.example.ecommerce.global.member.service;

import com.example.ecommerce.global.exception.CustomException;
import com.example.ecommerce.global.exception.ExceptionMessage;
import com.example.ecommerce.global.member.SignUpRepository;
import com.example.ecommerce.global.member.model.MemberDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final BCryptPasswordEncoder bcryptPasswordEncoder;

    private final SignUpRepository signUpRepository;
    public void signUp(MemberDto.SignUpDto signUpDto) {
        if(signUpRepository.existsByMemberId(signUpDto.getMemberId())) {
            throw new CustomException(ExceptionMessage.OVERLAPPED_ID);
        }
        String encodedPassword = bcryptPasswordEncoder.encode(signUpDto.getPassword());
        signUpDto.setPassword(encodedPassword);
        signUpRepository.save(signUpDto.dtoToEntity(signUpDto));
    }
}
