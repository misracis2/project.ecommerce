package com.example.ecommerce.global.member.service;

import com.example.ecommerce.global.common.MessageHandler;
import com.example.ecommerce.global.common.SuccessMessage;
import com.example.ecommerce.global.exception.CustomException;
import com.example.ecommerce.global.exception.ExceptionMessage;
import com.example.ecommerce.global.member.model.Customer;
import com.example.ecommerce.global.member.model.Seller;
import com.example.ecommerce.global.member.repository.CustomerRepository;
import com.example.ecommerce.global.member.model.MemberDto;
import com.example.ecommerce.global.member.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignUpService {

    private final BCryptPasswordEncoder bcryptPasswordEncoder;
    private final CustomerRepository customerRepository;
    private final SellerRepository sellerRepository;

    @Transactional
    public MessageHandler customerSignUp(MemberDto.SignUpDto signUpDto) {
        if(customerRepository.existsByMemberId(signUpDto.getMemberId())) {
            throw new CustomException(ExceptionMessage.OVERLAPPED_ID);
        }
        encodePassword(signUpDto);
        customerRepository.save(new Customer(signUpDto));
        return new MessageHandler(SuccessMessage.SING_UP);
    }

    public MessageHandler sellerSignUp(MemberDto.SignUpDto signUpDto) {
        if(sellerRepository.existsByMemberId(signUpDto.getMemberId())) {
            throw new CustomException(ExceptionMessage.OVERLAPPED_ID);
        }
        encodePassword(signUpDto);
        sellerRepository.save(new Seller(signUpDto));
        return new MessageHandler(SuccessMessage.SING_UP);
    }

    public void encodePassword(MemberDto.SignUpDto signUpDto){
        String encodedPassword = bcryptPasswordEncoder.encode(signUpDto.getPassword());
        signUpDto.setPassword(encodedPassword);
    }
}
