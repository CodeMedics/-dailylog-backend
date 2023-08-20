package com.ohgiraffers.dailylogbackend.member.command.application.service;

import com.ohgiraffers.dailylogbackend.member.command.application.dto.UpdateMemberDTO;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class UpdateMemberService {

    private final MemberRepository memberRepository;

    public UpdateMemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public boolean updateMemberInfo(Long memberNo, UpdateMemberDTO updateMemberDTO) {
        Optional<MemberEntity> findMember = memberRepository.findById(memberNo);
        if(findMember.isPresent()) {
            MemberEntity upDateMember = findMember.get();
            if (updateMemberDTO.getNickname() != null) {
                upDateMember.setNickname(upDateMember.getNickname());
            }
            if (updateMemberDTO.getProfileImage() != null) {
                upDateMember.setProfileImage(upDateMember.getProfileImage());
            }
        }
        return  true;
    }

}
