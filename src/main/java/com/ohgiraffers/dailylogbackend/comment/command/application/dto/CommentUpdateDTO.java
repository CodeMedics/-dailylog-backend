package com.ohgiraffers.dailylogbackend.comment.command.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentUpdateDTO {

    private Long diaryNo;

    private String commentContent;


    public CommentUpdateDTO(Long diaryNo, String commentContent) {
        this.diaryNo = diaryNo;
        this.commentContent = commentContent;
    }
}
