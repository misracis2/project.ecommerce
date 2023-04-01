package com.example.ecommerce.global.member.service;

import com.example.ecommerce.global.member.model.Customer;
import com.example.ecommerce.global.member.model.MemberGrade;
import com.example.ecommerce.global.member.model.Seller;
import com.example.ecommerce.global.member.model.dto.GradeDto;
import com.example.ecommerce.global.member.repository.CustomerRepository;
import com.example.ecommerce.global.member.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final CustomerRepository customerRepository;

    private final SellerRepository sellerRepository;

    //MemberGrade별 회원 조회
    public GradeDto.responseDto getGradeList(MemberGrade memberGrade){
        List<Customer> customerList = customerRepository.findByMemberGrade(memberGrade);
        List<Seller> sellerList = sellerRepository.findByMemberGrade(memberGrade);
        return new GradeDto.responseDto(customerList, sellerList);
    }
}
