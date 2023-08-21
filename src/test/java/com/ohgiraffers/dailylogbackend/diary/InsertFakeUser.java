package com.ohgiraffers.dailylogbackend.diary;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.EnumType.SocialEnum;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class InsertFakeUser {

    @Autowired
    private MemberRepository memberRepository;


    public MemberEntity insertFakeUser() {
        MemberEntity memberEntity = MemberEntity.builder()
                .UID("fake")
                .nickname("fake")
                .social(SocialEnum.KAKAO)
                .email("fake@email.com")
                .accessToken("fake")
                .accessTokenExpireDate(1L)
                .refreshToken("fake")
                .refreshTokenExpireDate(1L)
                .build();

        return memberRepository.save(memberEntity);
    }

    public void deleteFakeUser(MemberEntity memberEntity) {
        memberRepository.deleteById(memberEntity.getMemberNo());
    }
}
