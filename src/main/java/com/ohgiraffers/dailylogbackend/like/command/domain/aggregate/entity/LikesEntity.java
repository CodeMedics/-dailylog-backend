package com.ohgiraffers.dailylogbackend.like.command.domain.aggregate.entity;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.Member;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Likes")
@NoArgsConstructor
public class LikesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likesNo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no", nullable = false)
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diary_no", nullable = false)
    private DiaryEntity diary;

    public LikesEntity(Member member, DiaryEntity diary) {
        this.member = member;
        this.diary = diary;
    }
}

