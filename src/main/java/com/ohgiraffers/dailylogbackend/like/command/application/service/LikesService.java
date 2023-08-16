package com.ohgiraffers.dailylogbackend.like.command.application.service;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;

public interface LikesService{
    public void createLike(MemberEntity member, DiaryEntity diary);
    public void deleteLike(MemberEntity member, DiaryEntity diary);
    public void deleteLikeByNo(Long likeNo);
    public void unLike(Long diaryNo, Long memberNo);
    public void like(Long diaryNo, Long memberNo);
}
