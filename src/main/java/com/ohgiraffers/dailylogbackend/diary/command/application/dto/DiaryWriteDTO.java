package com.ohgiraffers.dailylogbackend.diary.command.application.dto;

import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DiaryWriteDTO {

    private String diaryContent;

    private String feelCategory;

    private MemberEntity memberEntity;

    public DiaryWriteDTO(String diaryContent, String feelCategory, MemberEntity memberEntity) {
        this.diaryContent = diaryContent;
        this.feelCategory = feelCategory;
        this.memberEntity = memberEntity;
    }
}
