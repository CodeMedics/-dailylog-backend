package com.ohgiraffers.dailylogbackend.diary.command.infra.service;

import com.ohgiraffers.dailylogbackend.diary.command.application.dto.DiaryUpdateDTO;
import com.ohgiraffers.dailylogbackend.diary.command.application.dto.DiaryWriteDTO;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;

import java.util.List;

public interface DiaryService {
    public DiaryEntity writeDiary(DiaryWriteDTO diaryWriteDTO);

    public void deleteDiary(Long diaryNo);

    public DiaryEntity updateDiary(Long diaryNo, DiaryUpdateDTO diaryUpdateDTO);
}
