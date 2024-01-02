package com.example.demo.service;

import com.example.demo.dto.MemberDto;
import com.example.demo.entity.MemberEntity;
import com.example.demo.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDto memberDto) {
        //1. dto -> entity 변환
        //2. repositoty의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDto);
        memberRepository.save(memberEntity);
        //repository의 save메서드 전송(조건, entity객체를 넘겨줘야 함)


    }
}
