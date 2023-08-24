package com.ohgiraffers.dailylogbackend.diary.query.application.service;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.diary.query.infra.mapper.DiaryMapper;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class GetDiaryService {

    private final DiaryMapper diaryMapper;

    @Autowired
    public GetDiaryService(DiaryMapper diaryMapper) {
        this.diaryMapper = diaryMapper;
    }

    public DiaryEntity getMyDiary(MemberEntity memberEntity, LocalDate diaryDate) {

        return diaryMapper.getMyDiary(memberEntity.getMemberNo(), diaryDate);
    }

    public Long[] getFeedInputDiary() {



            return diaryMapper.getFeedInputDiary();
    }
}
