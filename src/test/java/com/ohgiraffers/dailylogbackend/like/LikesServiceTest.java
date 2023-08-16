
package com.ohgiraffers.dailylogbackend.like;


import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.like.command.application.service.LikesServiceImpl;
import com.ohgiraffers.dailylogbackend.like.command.domain.aggregate.entity.LikesEntity;
import com.ohgiraffers.dailylogbackend.like.command.infra.repository.LikesRepository;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.EnumType.GenderEnum;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.EnumType.SocialEnum;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@DisplayName("비즈니스 로직 - 좋아요")
public class LikesServiceTest {

    @Autowired
    private LikesRepository likesRepository;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private DiaryRepository diaryRepository;
    @Autowired
    private LikesServiceImpl likesService;

    @BeforeEach
    public void setUp(){
        likesRepository.deleteAll();
        diaryRepository.deleteAll();
        memberRepository.deleteAll();
    }
    @Test
    @DisplayName("좋아요 생성 테스트")
    @Transactional
    public void testCreateLike() {
        //given
        MemberEntity memberEntity = createMember();
        DiaryEntity diaryEntity = createDiary(memberEntity);

        //when
        likesService.createLike(memberEntity, diaryEntity);

        //then
        Optional<LikesEntity> createdLike = likesRepository.findByMemberAndDiary(memberEntity, diaryEntity);
        assertThat(createdLike).isPresent();
    }

    @Test
    @DisplayName("좋아요 삭제 테스트")
    @Transactional
    public void testDeleteLike() {
        //given
        MemberEntity memberEntity = createMember();
        DiaryEntity diaryEntity = createDiary(memberEntity);
        likesService.createLike(memberEntity, diaryEntity);

        //when
        likesService.deleteLike(memberEntity, diaryEntity);

        //then
        Optional<LikesEntity> deletedLike = likesRepository.findByMemberAndDiary(memberEntity, diaryEntity);
        assertThat(deletedLike).isEmpty();
    }

    @Test
    @DisplayName("좋아요 번호로 삭제 테스트")
    @Transactional
    public void testDeleteLikeByNo() {
        //given
        MemberEntity memberEntity = createMember();
        DiaryEntity diaryEntity = createDiary(memberEntity);
        likesService.createLike(memberEntity, diaryEntity);

        //when
        likesService.deleteLikeByNo(1L);

        //then
        Optional<LikesEntity> deletedLike = likesRepository.findByMemberAndDiary(memberEntity, diaryEntity);
        assertThat(deletedLike).isEmpty();
    }

    @Test
    @DisplayName("좋아요 테스트")
    @Transactional
    public void testLike() {
        //given
        MemberEntity memberEntity = createMember();
        DiaryEntity diaryEntity = createDiary(memberEntity);
        memberEntity = memberRepository.saveAndFlush(memberEntity);
        diaryEntity = diaryRepository.saveAndFlush(diaryEntity);
        int original = diaryEntity.getLikeCount();

        //when
        likesService.like(memberEntity.getMemberNo(), diaryEntity.getDiaryNo());

        //then
        assertThat(diaryEntity.getLikeCount()).isEqualTo(original + 1);
        assertThat(likesRepository.findByMemberAndDiary(memberEntity, diaryEntity)).isPresent();
    }


    @Test
    @DisplayName("좋아요 취소 테스트")
    @Transactional
    public void testUnLike() {
        //givin
        MemberEntity memberEntity = createMember();
        DiaryEntity diaryEntity = createDiary(memberEntity);
        memberEntity = memberRepository.saveAndFlush(memberEntity);
        diaryEntity = diaryRepository.saveAndFlush(diaryEntity);
        likesService.like(memberEntity.getMemberNo(), diaryEntity.getDiaryNo());
        int original = diaryEntity.getLikeCount();
        System.out.println(original);

        //when
        likesService.unLike(memberEntity.getMemberNo(), diaryEntity.getDiaryNo());

        //then
        assertThat(diaryEntity.getLikeCount()).isEqualTo(original - 1);
        assertThat(likesRepository.findByMemberAndDiary(memberEntity, diaryEntity)).isEmpty();
    }

    private DiaryEntity createDiary(MemberEntity memberEntity) {
        DiaryEntity diaryEntity = new DiaryEntity();
        diaryEntity.setDiaryNo(1L);
        diaryEntity.setDiaryTitle("My First Diary");
        diaryEntity.setDiaryContent("This is the content of my first diary.");
        diaryEntity.setMember(memberEntity);
        diaryEntity.setFeelCategory("Happy");
        diaryEntity.setLikeCount(5);
        ;
        return diaryEntity;
    }

    private MemberEntity createMember() {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberNo(1L);
        memberEntity.setNickname("John");
        memberEntity.setProfileImage("profile.jpg");
        memberEntity.setGender(GenderEnum.MALE);
        memberEntity.setSocial(SocialEnum.KAKAO);
        memberEntity.setEmail("john@example.com");
        memberEntity.setAccessToken("token123");
        memberEntity.setAccessTokenExpireDate(1234567890L);
        memberEntity.setRefreshToken("refresh123");
        memberEntity.setRefreshTokenExpireDate(9876543210L);
        memberEntity.setSignUpDate(LocalDate.of(2023, 8, 1));
        memberEntity.setDeletedDate(null);
        memberEntity.setIsDeleted(DeleteEnum.PRESENT);
        memberEntity.setReportedCount(0);
        return memberEntity;
    }
}


