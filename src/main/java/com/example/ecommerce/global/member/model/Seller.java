package com.example.ecommerce.global.member.model;

import com.example.ecommerce.global.member.model.dto.MemberDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Seller extends Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String memberId;

    @Column(nullable = false)
    private String password;

//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//    private MemberRole memberRole;
//
//    @Column(nullable = false)
//    @Enumerated(EnumType.STRING)
//    private MemberGrade memberGrade;
    @Column
    private long sales;


    public Seller(MemberDto.SignUpDto signUpDto) {
        this.memberId = signUpDto.getMemberId();
        this.password = signUpDto.getPassword();
        this.memberRole = signUpDto.getMemberRole();
        this.memberGrade = MemberGrade.SILVER;
        this.sales = 0L;
    }

    @Override
    public MemberGrade getMemberGrade() {
        return memberGrade;
    }

//    public MemberGrade grade() {
//        if (sales < silverSales) {
//            return MemberGrade.SILVER;
//        } else if (sales < goldSales) {
//            return MemberGrade.GOLD;
//        } else {
//            return MemberGrade.PLATINUM;
//        }
//    }

}
