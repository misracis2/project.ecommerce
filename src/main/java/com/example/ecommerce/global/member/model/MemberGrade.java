package com.example.ecommerce.global.member.model;

public enum MemberGrade {
    SILVER("SILVER"),
    GOLD("GOLD"),
    PLATINUM("PLATINUM")
    ;

    private final String memberGrade;

    MemberGrade(String memberGrade) {
        this.memberGrade = memberGrade;
    }

    public String getMemberGrade() {
        return memberGrade;
    }
}
