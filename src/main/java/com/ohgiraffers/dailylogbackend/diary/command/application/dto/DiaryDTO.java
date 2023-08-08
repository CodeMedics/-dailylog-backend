package com.ohgiraffers.dailylogbackend.diary.command.application.dto;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DiaryDTO {

    private Long diaryNo;

    private String diaryTitle;

    private String diaryContent;

    private long memberNo;

    private String memberNickname;

    private String FeelCategory;

    private LocalDateTime writeDate;

    private int likeCount;

    @Builder
    public DiaryDTO(Long diaryNo, String diaryTitle, String diaryContent, long memberNo, String memberNickname, String feelCategory, LocalDateTime writeDate, int likeCount) {
        this.diaryNo = diaryNo;
        this.diaryTitle = diaryTitle;
        this.diaryContent = diaryContent;
        this.memberNo = memberNo;
        this.memberNickname = memberNickname;
        FeelCategory = feelCategory;
        this.writeDate = writeDate;
        this.likeCount = likeCount;
    }
}
