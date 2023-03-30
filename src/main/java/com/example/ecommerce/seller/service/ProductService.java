package com.example.ecommerce.seller.service;

import com.example.ecommerce.global.common.MessageHandler;
import com.example.ecommerce.global.common.SuccessMessage;
import com.example.ecommerce.global.exception.CustomException;
import com.example.ecommerce.global.exception.ExceptionMessage;
import com.example.ecommerce.global.member.model.Member;
import com.example.ecommerce.global.member.model.MemberGrade;
import com.example.ecommerce.global.member.repository.SellerRepository;
import com.example.ecommerce.seller.model.Product;
import com.example.ecommerce.seller.model.ProductDto;
import com.example.ecommerce.seller.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final SellerRepository sellerRepository;
    private final double silverFeeRate = 0.35;
    private final double goldFeeRate = 0.3;
    private final double platinumFeeRate = 0.25;
    public MessageHandler registerProduct(ProductDto.RegisterDto registerDto){
        Member seller = sellerRepository.findById(1L).orElseThrow(
                ()-> new CustomException(ExceptionMessage.NOT_EXIST_ID)
        );
        int commission = setCommission(seller, registerDto.getPrice());
        productRepository.save(new Product(registerDto.getTitle(),
                registerDto.getContent(),
                registerDto.getPrice(),
                registerDto.getStock(),
                commission));
        return new MessageHandler(SuccessMessage.REGISTER_PRODUCT);
    }
    public int setCommission(Member member, int price){
        if(member.getMemberGrade() == MemberGrade.SILVER){
            return (int) Math.round(price * silverFeeRate);
        }else if(member.getMemberGrade() == MemberGrade.GOLD){
            return (int) Math.round(price * goldFeeRate);
        }else{
            return (int) Math.round(price * platinumFeeRate);
        }
    }
}
