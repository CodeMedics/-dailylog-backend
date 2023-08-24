package com.ohgiraffers.dailylogbackend.feed.command.domain.aggregate.entity;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "feed")
@NoArgsConstructor
@Getter
public class FeedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedNo;

    @OneToOne
    @JoinColumn(name = "diary_no")
    private DiaryEntity diaryEntity;

    public FeedEntity(DiaryEntity diaryEntity) {
        this.diaryEntity = diaryEntity;
    }
}