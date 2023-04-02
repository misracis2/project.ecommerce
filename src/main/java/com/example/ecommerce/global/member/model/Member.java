package com.example.ecommerce.global.member.model;

import javax.persistence.*;

public class Member {

    //SELLER 회원 매출 등급
    final long silverSales = 10000000;
    final long goldSales = 100000000;

    //CUSTOMER 회원 구매 등급
    final long silverPurchase = 200000;
    final long goldPurchase = 500000;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String memberId;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberRole memberRole;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private MemberGrade memberGrade;

    public MemberGrade getMemberGrade() {
        return memberGrade;
    }

    public void setMemberGrade(MemberGrade memberGrade) {
        this.memberGrade = memberGrade;
    }
}
