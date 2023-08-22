package com.ohgiraffers.dailylogbackend.diary.command.application.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class DiaryUpdateDTO {

    private String diaryContent;

    private String feelCategory;

    @Builder
    public DiaryUpdateDTO(String diaryContent, String feelCategory) {
        this.diaryContent = diaryContent;
        this.feelCategory = feelCategory;
    }
}
