package com.example.ecommerce.global.member.model.dto;

import com.example.ecommerce.global.member.model.Customer;
import com.example.ecommerce.global.member.model.Seller;
import lombok.Getter;

import java.util.List;

public class GradeDto {

    @Getter
    public static class responseDto{

        List<Customer> customerList;

        List<Seller> sellerList;

        public responseDto(List<Customer> customerList, List<Seller> sellerList) {
            this.customerList = customerList;
            this.sellerList = sellerList;
        }
    }
}
