package com.example.ecommerce.global.member.model;

import com.example.ecommerce.global.member.model.dto.MemberDto;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Customer extends Member{

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

    private long purchaseAmount;

    public Customer(MemberDto.SignUpDto signUpDto) {
        this.memberId = signUpDto.getMemberId();
        this.password = signUpDto.getPassword();
        this.memberRole = signUpDto.getMemberRole();
        this.memberGrade = MemberGrade.SILVER;
        this.purchaseAmount = 0L;
    }



    public MemberGrade grade() {
        if (purchaseAmount < silverPurchase) {
            return MemberGrade.SILVER;
        } else if (purchaseAmount < goldPurchase) {
            return MemberGrade.GOLD;
        } else {
            return MemberGrade.PLATINUM;
        }
    }
}
