package com.ohgiraffers.dailylogbackend.like.command.infra.service;


import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.like.command.domain.aggregate.entity.LikesEntity;
import com.ohgiraffers.dailylogbackend.like.command.infra.repository.LikesRepository;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.Member;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.Optional;

@Service
public class LikesService {

//    private final LikesRepository likesRepository;
//    private final DiaryRepository diaryRepository;
//    private final UserRepository userRepository;
//
//    public LikesService(LikesRepository likesRepository, UserRepository userRepository, DiaryRepository diaryRepository) {
//        this.likesRepository = likesRepository;
//        this.diaryRepository = diaryRepository;
//        this.userRepository = userRepository;
//    }
//
//    //좋아요 생성
//    public void createLike(Member member, DiaryEntity diary) {
//        LikesEntity likes = new LikesEntity(member, diary);
//        likesRepository.save(likes);
//    }
//
//    //좋아요 누르기
//    public void clickLike(Long diaryNo, Long member_no) {
//        DiaryEntity diary = diaryRepository.findById(diaryNo)
//                .orElseThrow(() -> new EntityNotFoundException("Diary not found with id: " + diaryNo));
//
//        Member member = userRepository.findById(member_no)
//                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + member_no));
//
//        Optional<LikesEntity> like = likesRepository.findByDiaryNoAndMember_No(diaryNo, member_no);
//        // 이미 좋아요를 눌렀으면 제거
//        if (like.isPresent()) {
//            likesRepository.delete(like.get());
//            diary.setLikeCount(diary.getLikeCount() - 1);
//        }
//        // 아직 좋아요를 안 눌렀으면 추가
//        else {
//            createLike(member, diary);
//            diary.setLikeCount(diary.getLikeCount() + 1);
//        }
//        diaryRepository.save(diary);
//    }
}
