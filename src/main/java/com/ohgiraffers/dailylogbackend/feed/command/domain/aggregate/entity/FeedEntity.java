package com.ohgiraffers.dailylogbackend.feed.command.domain.aggregate.entity;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "feed")
@NoArgsConstructor
public class FeedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feedNo;

    @JoinColumn
    @ManyToOne
    private DiaryEntity diaryNo;

    public FeedEntity(DiaryEntity diaryNo) {
        this.diaryNo = diaryNo;
    }
}
