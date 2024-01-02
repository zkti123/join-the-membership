package com.example.demo.entity;

import com.example.demo.dto.MemberDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Member;

@Entity
@Setter
@Getter
@Table(name = "member_table")
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(unique = true)
    private String memberEamil;

    @Column
    private String memberPassword;

    @Column
    private String memberName;


    public static MemberEntity toMemberEntity(MemberDto memberDto) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEamil(memberDto.getMemberEmail());
        memberEntity.setMemberName(memberDto.getMemberName());
        memberEntity.setMemberPassword(memberDto.getMemberPassword());
        return memberEntity;
    }
}
