package com.ohgiraffers.dailylogbackend.diary;

import com.ohgiraffers.dailylogbackend.diary.command.infra.repository.DiaryRepository;
import com.ohgiraffers.dailylogbackend.feed.command.infra.repository.FeedRepository;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.EnumType.SocialEnum;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;


@Service
public class InsertFakeUser {

    @Autowired
    private MemberRepository memberRepository;

    @Autowired
    private DiaryRepository diaryRepository;

    @Autowired
    private FeedRepository feedRepository;


    @Transactional
    public MemberEntity insertFakeUser() {
        MemberEntity memberEntity = MemberEntity.builder()
                .UID("fake")
                .nickname("fake" + LocalDateTime.now())
                .social(SocialEnum.KAKAO)
                .email("fake@email.com")
                .accessToken("fake")
                .accessTokenExpireDate(1L)
                .refreshToken("fake")
                .refreshTokenExpireDate(1L)
                .build();

        return memberRepository.save(memberEntity);
    }

    @Transactional
    public void deleteFakeData(MemberEntity memberEntity) {
        feedRepository.deleteAll();
        diaryRepository.deleteAllByMemberEntity(memberEntity);
        memberRepository.deleteById(memberEntity.getMemberNo());
    }
}
