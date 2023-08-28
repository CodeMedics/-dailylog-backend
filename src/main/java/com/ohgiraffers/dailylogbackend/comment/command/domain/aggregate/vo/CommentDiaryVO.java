package com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.vo;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
@Getter
@ToString
public class CommentDiaryVO {

    @Column(name = "diary_no")
    private Long diaryNo;

    public CommentDiaryVO(Long diaryNo) {
        this.diaryNo = diaryNo;
    }

    public CommentDiaryVO() {

    }
}
