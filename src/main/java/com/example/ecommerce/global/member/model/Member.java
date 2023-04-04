package com.example.ecommerce.global.member.model;

import lombok.Getter;

import javax.persistence.*;

@MappedSuperclass
@Getter
public abstract class Member {

//    //SELLER 회원 매출 등급
//    final long silverSales = 10000000;
//    final long goldSales = 100000000;
//
//    //CUSTOMER 회원 구매 등급
//    final long silverPurchase = 200000;
//    final long goldPurchase = 500000;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected MemberRole memberRole;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    protected MemberGrade memberGrade;

    public MemberGrade getMemberGrade() {
        return memberGrade;
    }

    public void setMemberGrade(MemberGrade memberGrade) {
        this.memberGrade = memberGrade;
    }
}
