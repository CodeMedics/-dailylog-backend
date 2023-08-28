package com.ohgiraffers.dailylogbackend.comment.command.application.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentSaveDTO {

    private Long commentNo;

    private String commentContent;

    private Long diaryNo;

    private Long memberNo;

    private String nickname;


    public CommentSaveDTO() {
        this.commentNo = commentNo;
        this.commentContent = commentContent;
        this.diaryNo = diaryNo;
        this.memberNo = memberNo;
        this.nickname = nickname;
    }

    public CommentSaveDTO(Long commentNo, String commentContent, Long diaryNo, Long memberNo, String nickname) {
        this.commentNo = commentNo;
        this.commentContent = commentContent;
        this.diaryNo = diaryNo;
        this.memberNo = memberNo;
        this.nickname = nickname;
    }
}



