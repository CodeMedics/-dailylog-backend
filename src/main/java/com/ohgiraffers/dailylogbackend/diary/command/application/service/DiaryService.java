package com.ohgiraffers.dailylogbackend.diary.command.application.service;

import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.diary.command.application.dto.DiaryUpdateDTO;
import com.ohgiraffers.dailylogbackend.diary.command.application.dto.DiaryWriteDTO;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.diary.command.infra.repository.DiaryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DiaryService {

    private final DiaryRepository diaryRepository;

    public DiaryService(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    @Transactional
    public DiaryEntity writeDiary(DiaryWriteDTO diaryWriteDTO) {

        DiaryEntity diaryEntity = new DiaryEntity(diaryWriteDTO.getMemberEntity(),
                diaryWriteDTO.getDiaryContent(),
                diaryWriteDTO.getFeelCategory());

        return diaryRepository.save(diaryEntity);
    }

    @Transactional
    public DiaryEntity deleteDiary(Long diaryNo) {
        DiaryEntity diaryEntity = diaryRepository.getReferenceById(diaryNo);

        diaryEntity.setIfDelete(DeleteEnum.DELETED);

        return diaryRepository.save(diaryEntity);
    }

    @Transactional
    public DiaryEntity updateDiary(Long diaryNo, DiaryUpdateDTO diaryUpdateDTO) {
        Optional<DiaryEntity> opDe = diaryRepository.findById(diaryNo);

        DiaryEntity diaryEntity = opDe.get();

        System.out.println(diaryEntity.getDiaryContent());

        diaryEntity.updateDiaryEntity(diaryUpdateDTO.getDiaryContent(), diaryUpdateDTO.getFeelCategory());

        return diaryRepository.save(diaryEntity);
    }

}
