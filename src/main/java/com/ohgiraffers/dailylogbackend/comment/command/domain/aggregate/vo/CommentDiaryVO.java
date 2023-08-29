package com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.vo;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;


@Embeddable
@Getter
@ToString
public class CommentDiaryVO {

    @ManyToOne
    @JoinColumn
    private DiaryEntity diaryNo;

    public CommentDiaryVO(DiaryEntity diaryNo) {
        this.diaryNo = diaryNo;
    }

    public CommentDiaryVO() {

    }
}
