package com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class Entity {

    @Id()
    @Column(name = "comment_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "comment_date")
    private LocalDate commentDate;

    @Column(name = "diary_no")
    private Long diaryNo;

    @Column(name = "member_no")
    private Long memberNo;


}
