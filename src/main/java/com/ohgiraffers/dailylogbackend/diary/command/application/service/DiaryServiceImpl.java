package com.ohgiraffers.dailylogbackend.diary.command.application.service;

import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.diary.command.application.dto.DiaryUpdateDTO;
import com.ohgiraffers.dailylogbackend.diary.command.application.dto.DiaryWriteDTO;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.diary.command.infra.repository.DiaryRepository;
import com.ohgiraffers.dailylogbackend.diary.command.infra.service.DiaryService;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class DiaryServiceImpl implements DiaryService {

    private final DiaryRepository diaryRepository;

    public DiaryServiceImpl(DiaryRepository diaryRepository) {
        this.diaryRepository = diaryRepository;
    }

    @Override
    @Transactional
    public DiaryEntity writeDiary(DiaryWriteDTO diaryWriteDTO) {

        DiaryEntity diaryEntity = new DiaryEntity(diaryWriteDTO.getMemberEntity(),
                diaryWriteDTO.getDiaryContent(),
                diaryWriteDTO.getFeelCategory());

        return diaryRepository.save(diaryEntity);
    }

    @Override
    @Transactional
    public void deleteDiary(Long diaryNo) {
        DiaryEntity diaryEntity = diaryRepository.getReferenceById(diaryNo);

        diaryEntity.setIfDelete(DeleteEnum.DELETED);
    }

    @Override
    @Transactional
    public DiaryEntity updateDiary(Long diaryNo, DiaryUpdateDTO diaryUpdateDTO) {
        Optional<DiaryEntity> opDe = diaryRepository.findById(diaryNo);

        DiaryEntity diaryEntity = opDe.get();

        System.out.println(diaryEntity.getDiaryContent());

        diaryEntity.updateDiaryEntity(diaryUpdateDTO.getDiaryContent(), diaryUpdateDTO.getFeelCategory());

        return diaryRepository.save(diaryEntity);
    }

}
