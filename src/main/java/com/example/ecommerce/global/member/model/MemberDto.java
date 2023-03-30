package com.example.ecommerce.global.member.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
public class MemberDto {
    @Getter
    @Setter
    public static class SignUpDto{
        @ApiModelProperty(value = "아이디", required = true)
        private String memberId;

        @ApiModelProperty(value = "비밀번호", required = true)
        private String password;

        @ApiModelProperty(value = "가입유형(CUSTOMER, SELLER, ADMIN)", required = true)
        private MemberRole memberRole;

        public void setPassword(String password) {
            this.password = password;
        }

        public Customer dtoToEntity(SignUpDto signUpDto) {
        return new Customer(signUpDto);
        }
    }

}
