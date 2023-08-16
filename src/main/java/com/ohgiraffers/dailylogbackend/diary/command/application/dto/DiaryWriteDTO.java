package com.ohgiraffers.dailylogbackend.diary.command.application.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class DiaryWriteDTO {

    private String diaryContent;

    private String feelCategory;

    @Builder
    public DiaryWriteDTO(String diaryContent, String feelCategory) {
        this.diaryContent = diaryContent;
        this.feelCategory = feelCategory;
    }
}
