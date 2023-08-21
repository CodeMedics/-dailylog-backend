package com.ohgiraffers.dailylogbackend.member.command.domain.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.dailylogbackend.member.command.application.dto.MemberDTO;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.EnumType.SocialEnum;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;

    @Autowired
    public MemberService(MemberRepository memberRepository, ModelMapper modelMapper, ObjectMapper objectMapper) {
        this.memberRepository = memberRepository;
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
    }

    public MemberDTO findByUID(SocialEnum social , String UID) {
        MemberEntity foundMember = memberRepository.findByUID(UID, social);

        if(foundMember == null) {
            return  null;
        } else {
            return modelMapper.map(foundMember, MemberDTO.class);
        }
    }
}
