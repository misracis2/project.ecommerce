package com.example.ecommerce.global.member.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class Member {

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

    public Member(MemberDto.SignUpDto signUpDto) {
        this.memberId = signUpDto.getMemberId();
        this.password = signUpDto.getPassword();
        this.memberRole = signUpDto.getMemberRole();

    }
}
