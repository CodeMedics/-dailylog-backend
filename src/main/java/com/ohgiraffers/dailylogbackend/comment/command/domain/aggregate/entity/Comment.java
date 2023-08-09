package com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.entity;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;

import javax.persistence.*;
import java.time.LocalDateTime;


public class Comment {

    @Id
    @Column(name = "comment_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "comment_is_deleted")
    private boolean commentIsDeleted;

    @Column(name = "comment_date")
    private LocalDateTime commentDate;

    @JoinColumn(name = "diary_no")
    private DiaryEntity diaryNo;

    @JoinColumn(name = "member_no")
    private MemberEntity memberNo;

    public Comment(Long commentNo, String commentContent, boolean commentIsDeleted, LocalDateTime commentDate, DiaryEntity diaryNo, MemberEntity memberNo) {
        this.commentNo = commentNo;
        this.commentContent = commentContent;
        this.commentIsDeleted = commentIsDeleted;
        this.commentDate = commentDate;
        this.diaryNo = diaryNo;
        this.memberNo = memberNo;
    }
}
