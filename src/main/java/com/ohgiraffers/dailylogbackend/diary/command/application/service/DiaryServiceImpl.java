package com.ohgiraffers.dailylogbackend.diary.command.application.service;

import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.diary.command.application.dto.DiaryUpdateDTO;
import com.ohgiraffers.dailylogbackend.diary.command.application.dto.DiaryWriteDTO;
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
    public DiaryEntity writeDiary(DiaryWriteDTO diaryWriteDTO) {
        DiaryEntity diaryEntity = DiaryEntity.builder()
                .diaryContent(diaryWriteDTO.getDiaryContent())
                .feelCategory(diaryWriteDTO.getFeelCategory())
                .build();

        return diaryRepository.save(diaryEntity);
    }

    @Override
    public void deleteDiary(Long diaryNo) {
        DiaryEntity diaryEntity = diaryRepository.getReferenceById(diaryNo);

        diaryEntity.setIfDelete(DeleteEnum.DELETED);
    }

    @Override
    public void updateDiary(Long diaryNo, DiaryUpdateDTO diaryUpdateDTO) {
        DiaryEntity diaryEntity = diaryRepository.getReferenceById(diaryNo);

        diaryEntity.updateDiaryEntity(diaryUpdateDTO.getDiaryContent(), diaryUpdateDTO.getFeelCategory());

    }

}
