package com.example.ecommerce.global.member.service;

import com.example.ecommerce.global.member.model.*;
import com.example.ecommerce.global.member.model.dto.GradeDto;
import com.example.ecommerce.global.member.repository.CustomerRepository;
import com.example.ecommerce.global.member.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GradeService {

    private final CustomerRepository customerRepository;

    private final SellerRepository sellerRepository;

    //MemberGrade별 회원 조회
    public List<GradeDto.ResponseDto> getGradeList(MemberGrade memberGrade, MemberRole memberRole){
        List<GradeDto.ResponseDto> responseList = new ArrayList<>();

        if(memberRole == MemberRole.CUSTOMER){
            List<Customer> CustomerList = new ArrayList<>(customerRepository.findByMemberGrade(memberGrade));
            for (Customer customer : CustomerList) {
                responseList.add(new GradeDto.ResponseDto(customer));
            }
        }else if(memberRole == MemberRole.SELLER){
            List<Seller> sellerList = new ArrayList<>(sellerRepository.findByMemberGrade(memberGrade));
            for (Seller seller : sellerList) {
                responseList.add(new GradeDto.ResponseDto(seller));
            }
        }else{
            throw new IllegalArgumentException("MemberRole을 확인해주세요");
        }
        return responseList;
    }
}
