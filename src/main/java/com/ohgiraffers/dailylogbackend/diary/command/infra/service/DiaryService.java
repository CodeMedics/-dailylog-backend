package com.ohgiraffers.dailylogbackend.diary.command.infra.service;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;

import java.util.List;

public interface DiaryService {
    public DiaryEntity writeDiary(DiaryEntity diaryEntity);

    public void deleteDiary(DiaryEntity diaryEntity);

    public void updateDiary(DiaryEntity diaryEntity);
}
