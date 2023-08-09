package com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity;

import com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.entity.Comment;
import com.ohgiraffers.dailylogbackend.common.AuditingFields;
import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "diary")
@Getter
@Setter
public class DiaryEntity extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryNo;

    @Column(length = 500, nullable = false)
    private String diaryContent;

//    @ManyToOne
//    @JoinColumn(name="member_no", nullable = false)
//    private MemberEntity member;

    @Column(length = 20, nullable = false)
    private String FeelCategory;

    @Column
    private int likeCount;

    @Column(nullable = false)
    private DeleteEnum ifDelete;

//    @OneToMany
//    @JoinColumn(name="comment_no")
//    private List<Comment> comments = new ArrayList<>();

    @PrePersist
    public void prePersist() {
        ifDelete = DeleteEnum.PRESENT;
        likeCount = 0;
    }
}
