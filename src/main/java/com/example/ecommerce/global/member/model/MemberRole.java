package com.example.ecommerce.global.member.model;

public enum MemberRole {

    CUSTOMER("CUSTOMER"),
    SELLER("SELLER"),
    ADMIN("ADMIN")
    ;

    private final String memberRole;

    MemberRole(String memberRole) {
        this.memberRole = memberRole;
    }

    public String getMemberRole() {
        return memberRole;
    }
}
