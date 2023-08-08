package com.ohgiraffers.dailylogbackend.diary.command.application.service;

import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.diary.command.infra.repository.DiaryRepository;
import com.ohgiraffers.dailylogbackend.diary.command.infra.service.DiaryService;
import org.springframework.stereotype.Service;

@Service
public class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository diaryRepository;

    public DiaryServiceImpl(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    @Override
    public DiaryEntity writeDiary(DiaryEntity diaryEntity) {
        return diaryRepository.save(diaryEntity);
    }

    @Override
    public void deleteDiary(DiaryEntity diaryEntity) {
        diaryEntity.setIfDelete(DeleteEnum.DELETED);

        diaryRepository.save(diaryEntity);
    }

    @Override
    public void updateDiary(DiaryEntity diaryEntity) {
        diaryRepository.save(diaryEntity);
    }

}
