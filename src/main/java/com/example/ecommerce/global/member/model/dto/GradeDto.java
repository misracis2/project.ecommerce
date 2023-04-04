package com.example.ecommerce.global.member.model.dto;

import com.example.ecommerce.global.member.model.Customer;
import com.example.ecommerce.global.member.model.MemberGrade;
import com.example.ecommerce.global.member.model.MemberRole;
import com.example.ecommerce.global.member.model.Seller;
import lombok.Getter;
import lombok.Setter;

@Getter
public class GradeDto {

    @Getter
    @Setter
    public static class ResponseDto {


        private Long id;

        private String memberId;

        private MemberRole memberRole;

        private MemberGrade memberGrade;

        public ResponseDto(Customer member) {
            this.id = member.getId();
            this.memberId = member.getMemberId();
            this.memberRole = member.getMemberRole();
            this.memberGrade = member.getMemberGrade();
        }
        public ResponseDto(Seller member) {
            this.id = member.getId();
            this.memberId = member.getMemberId();
            this.memberRole = member.getMemberRole();
            this.memberGrade = member.getMemberGrade();
        }
    }
}
