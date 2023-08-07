package com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "diary")
public class DiaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryNo;

    @Column(length = 100, nullable = false)
    private String diaryTitle;

    @Column(length = 500, nullable = false)
    private String diaryContent;

//    @OneToMany
//    @JoinColumn(name="member_no", nullable = false)
    @Column(nullable = false)
    private long memberNo;

    @Column(length = 30, nullable = false)
    private String memberNickname;

    @Column(length = 20, nullable = false)
    private String FeelCategory;

    @Column(nullable = false)
    private LocalDateTime writeDate;

    @Column
    private int likeCount;

}
