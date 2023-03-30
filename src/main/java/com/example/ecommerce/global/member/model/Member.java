package com.example.ecommerce.global.member.model;

public interface Member {

    //SELLER 회원 매출 등급
    final long silverSales = 10000000;
    final long goldSales = 100000000;

    //CUSTOMER 회원 구매 등급
    final long silverPurchase = 200000;
    final long goldPurchase = 500000;

    public MemberGrade getMemberGrade();
}
