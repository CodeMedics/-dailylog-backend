package com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity;

import com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.entity.CommentEntity;
import com.ohgiraffers.dailylogbackend.common.AuditingFields;
import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "diary")
@NoArgsConstructor
@Getter
public class DiaryEntity extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryNo;

    @Column(length = 500, nullable = false)
    private String diaryContent;

    @ManyToOne
    @JoinColumn(name="member_no", nullable = false)
    private MemberEntity memberEntity;

    @Column(length = 20, nullable = false)
    private String feelCategory;

    @Column
    private int likeCount;

    @Column
    private DeleteEnum ifDelete;

    @OneToMany
    @JoinColumn(name="comment_no")
    private List<CommentEntity> comments;

    @PrePersist
    public void prePersist() {
        ifDelete = DeleteEnum.PRESENT;
        likeCount = 0;
    }

    public DiaryEntity (MemberEntity memberEntity, String diaryContent, String feelCategory) {
        this.memberEntity = memberEntity;
        this.diaryContent = diaryContent;
        this.feelCategory = feelCategory;
    }

    public DiaryEntity(Long diaryNo) {
        this.diaryNo = diaryNo;
    }

    public void updateDiaryEntity(String diaryContent, String feelCategory) {
        this.diaryContent = diaryContent;
        this.feelCategory = feelCategory;
    }

    public void setIfDelete(DeleteEnum ifDelete) {
        this.ifDelete = ifDelete;
    }
}
