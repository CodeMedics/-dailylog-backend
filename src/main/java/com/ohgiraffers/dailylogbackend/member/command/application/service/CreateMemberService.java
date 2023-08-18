package com.ohgiraffers.dailylogbackend.member.command.application.service;

import com.ohgiraffers.dailylogbackend.member.command.application.dto.CreateMemberDTO;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateMemberService {


    private final MemberRepository memberRepository;

    @Autowired
    public CreateMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberEntity create(CreateMemberDTO createMemberDTO) {
        MemberEntity createMember = new MemberEntity(
                createMemberDTO.getUID(),
                createMemberDTO.getNickname(),
                createMemberDTO.getProfileImage(),
                createMemberDTO.getAccessToken(),
                createMemberDTO.getRefreshToken(),
                createMemberDTO.getSocial(),
                createMemberDTO.getIsDeleted()
        );

        return memberRepository.save(createMember);
    }
}
