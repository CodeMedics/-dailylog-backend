package com.ohgiraffers.dailylogbackend.diary.command.application.dto;

import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class DiaryWriteDTO {

    private MemberEntity memberEntity;

    private String diaryContent;

    private String feelCategory;

    private LocalDate diaryDate;

    public DiaryWriteDTO(MemberEntity memberEntity, String diaryContent, String feelCategory, LocalDate diaryDate) {
        this.memberEntity = memberEntity;
        this.diaryContent = diaryContent;
        this.feelCategory = feelCategory;
        this.diaryDate = diaryDate;
    }
}
