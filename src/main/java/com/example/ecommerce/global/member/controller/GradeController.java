package com.example.ecommerce.global.member.controller;

import com.example.ecommerce.global.member.model.MemberGrade;
import com.example.ecommerce.global.member.model.MemberRole;
import com.example.ecommerce.global.member.model.dto.GradeDto;
import com.example.ecommerce.global.member.service.GradeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/grade")
public class GradeController {

    private final GradeService gradeService;

    @ApiOperation(value = "등급별 회원 조회")
    @GetMapping()
    public List<GradeDto.ResponseDto> getGradeList(@RequestParam("memberGrade") @ApiParam(value = "회원 등급") String grade,
                                                   @RequestParam("memberRole") @ApiParam(value = "회원 분류") String role) {
        MemberGrade memberGrade = MemberGrade.valueOf(grade);
        MemberRole memberRole = MemberRole.valueOf(role);
        return gradeService.getGradeList(memberGrade, memberRole);
    }
}
