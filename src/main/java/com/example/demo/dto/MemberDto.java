package com.example.demo.dto;

import com.example.demo.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MemberDto {
    private Long id;
    private String memberEmail;
    private String memberPassword;
    private String memberName;

    public static MemberDto toMemberDto(MemberEntity memberEntity) {
        MemberDto memberDto = new MemberDto();
        memberDto.setId(memberEntity.getId());
        memberDto.setMemberEmail(memberEntity.getMemberEmail());
        memberDto.setMemberName(memberEntity.getMemberName());
        memberDto.setMemberPassword(memberEntity.getMemberPassword());
        return memberDto;
    }
}
