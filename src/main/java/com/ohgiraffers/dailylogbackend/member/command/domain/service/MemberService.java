package com.ohgiraffers.dailylogbackend.member.command.domain.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.dailylogbackend.member.command.application.dto.MemberDTO;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.repository.MemberRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum.PRESENT;

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

    public MemberDTO findByUID(String socialLogin , String UID) {
        MemberEntity foundMember = memberRepository.findByUID(UID, socialLogin);

        if(foundMember == null) {
            return  null;
        } else {
            return modelMapper.map(foundMember, MemberDTO.class);
        }
    }

    public MemberDTO getAuthedMember(String header) throws JsonProcessingException {

        Map<String, String> headerMap = objectMapper.readValue(header, Map.class);

        String id = String.valueOf(headerMap.get("memberNo"));

        Long memberNo = Long.parseLong(id);

        MemberEntity authedMember = (MemberEntity) memberRepository.findByUID(memberNo);

        return modelMapper.map(authedMember, MemberDTO.class);
    }

    public Long registNewMember(MemberDTO newMember) {

        newMember.setNickname("신규회원" + (Math.random() * 100) +1);
        newMember.setIsDeleted(PRESENT);

        return memberRepository.save(modelMapper.map(newMember, MemberEntity.class)).getMemberNo();
    }
}
