package com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity;

import com.ohgiraffers.dailylogbackend.common.AuditingFields;
import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "diary")
@Setter
@Getter
public class DiaryEntity extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryNo;

    @Column(length = 100, nullable = false)
    private String diaryTitle;

    @Column(length = 500, nullable = false)
    private String diaryContent;

    @ManyToOne
    @JoinColumn(name="member_no", nullable = false)
    private MemberEntity member;

    @Column(length = 20, nullable = false)
    private String FeelCategory;

    @Column
    private int likeCount;

    @Column(nullable = false)
    private DeleteEnum ifDelete;

}
