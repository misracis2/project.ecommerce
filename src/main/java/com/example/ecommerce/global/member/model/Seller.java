package com.example.ecommerce.global.member.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Seller implements Member {

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
    private MemberGrade memberGrade = MemberGrade.SILVER;
    @Column
    private long sales = 0L;


    public Seller(MemberDto.SignUpDto signUpDto) {
        this.memberId = signUpDto.getMemberId();
        this.password = signUpDto.getPassword();
        this.memberRole = signUpDto.getMemberRole();
    }

    @Override
    public MemberGrade getMemberGrade() {
        return memberGrade;
    }

    public void setMemberGrade(MemberGrade memberGrade) {
        this.memberGrade = memberGrade;
    }

    public MemberGrade grade() {
        if (sales < silverSales) {
            return MemberGrade.SILVER;
        } else if (sales < goldSales) {
            return MemberGrade.GOLD;
        } else {
            return MemberGrade.PLATINUM;
        }
    }

}
