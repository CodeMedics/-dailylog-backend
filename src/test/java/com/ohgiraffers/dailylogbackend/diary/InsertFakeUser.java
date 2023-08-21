//package com.ohgiraffers.dailylogbackend.diary;
//
//import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.EnumType.SocialEnum;
//import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
//import com.ohgiraffers.dailylogbackend.member.command.domain.repository.MemberRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//
//@SpringBootTest
//public class InsertFakeUser {
//
//    @Autowired
//    private MemberRepository memberRepository;
//
//
//    @Test
//    public void insertFakeUser() {
//
//        for (int i = 0; i < 10; i++) {
//            MemberEntity memberEntity = MemberEntity.builder()
//                    .UID("fake")
//                    .nickname("fake" +  i)
//                    .social(SocialEnum.KAKAO)
//                    .email("fake@email.com")
//                    .accessToken("fake")
//                    .accessTokenExpireDate(1L)
//                    .refreshToken("fake")
//                    .refreshTokenExpireDate(1L)
//                    .build();
//
//            memberRepository.save(memberEntity);
//        }
//    }
//}
