package com.ohgiraffers.dailylogbackend.like.command.application.service;


import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.like.command.domain.aggregate.entity.LikesEntity;
import com.ohgiraffers.dailylogbackend.like.command.infra.repository.LikesRepository;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LikesServiceImpl implements LikesService{

    private final LikesRepository likesRepository;
//    private final DiaryRepository diaryRepository;
//    private final MemberRepository memberRepository;

    public LikesServiceImpl(LikesRepository likesRepository /*, MemberRepository memberRepository, DiaryRepository diaryRepository */) {
        this.likesRepository = likesRepository;
//        this.diaryRepository = diaryRepository;
//        this.memberRepository = memberRepository;
    }
    @Override
    @Transactional
    public void like(Long memberNo, Long diaryNo) {

    }
    //        MemberEntity member = memberRepository.findById(memberNo)
//                .orElseThrow(() -> new EntityNotFoundException("Member not found with id: " + memberNo));
//        DiaryEntity diary = diaryRepository.findById(diaryNo)
//                .orElseThrow(() -> new EntityNotFoundException("Diary not found with id: " + diaryNo));
//        Optional<LikesEntity> like = likesRepository.findByMemberAndDiary(member, diary);
//        if (like.isEmpty()) {
//            createLike(member, diary);
//            int temp = diary.getLikeCount();
//            diary.setLikeCount(temp + 1);
//            diaryRepository.saveAndFlush(diary);
//        }else{
//            throw new EntityNotFoundException("like not found");
//        }
//    }
    @Override
    @Transactional
    public void unLike(Long memberNo, Long diaryNo) {}
    //        MemberEntity member = memberRepository.findById(memberNo)
//                .orElseThrow(() -> new EntityNotFoundException("Member not found with id: " + memberNo));
//        DiaryEntity diary = diaryRepository.findById(diaryNo)
//                .orElseThrow(() -> new EntityNotFoundException("Diary not found with id: " + diaryNo));
//        Optional<LikesEntity> like = likesRepository.findByMemberAndDiary(member, diary);
//        if (like.isPresent()) {
//            deleteLike(member, diary);
//            diary.setLikeCount(diary.getLikeCount() - 1);
//            diaryRepository.saveAndFlush(diary);
//        }
//    }
    @Override
    @Transactional
    public void createLike(MemberEntity member, DiaryEntity diary) {
        LikesEntity likesEntity = new LikesEntity(member, diary);
        likesRepository.save(likesEntity);
    }
    @Override
    @Transactional
    public void deleteLike(MemberEntity member, DiaryEntity diary) {
        Optional<LikesEntity> like = likesRepository.findByMemberAndDiary(member, diary);
        likesRepository.delete(like.get());
    }
    @Override
    @Transactional
    public void deleteLikeByNo(Long likeNo){
        likesRepository.deleteById(likeNo);
    }

}
