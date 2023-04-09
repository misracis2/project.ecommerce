package com.example.ecommerce.global.member.service;

import com.example.ecommerce.global.member.model.Customer;
import com.example.ecommerce.global.member.model.MemberGrade;
import com.example.ecommerce.global.member.model.MemberRole;
import com.example.ecommerce.global.member.model.Seller;
import com.example.ecommerce.global.member.model.dto.GradeDto;
import com.example.ecommerce.global.member.repository.CustomerRepository;
import com.example.ecommerce.global.member.repository.SellerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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
        int page = 1;

        if(memberRole == MemberRole.CUSTOMER){
            PageRequest pageRequest = PageRequest.of(page - 1, 10, Sort.by(Sort.Direction.DESC, "purchaseAmount"));
            List<Customer> CustomerList = new ArrayList<>(customerRepository.findByMemberGrade(memberGrade, pageRequest));
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
