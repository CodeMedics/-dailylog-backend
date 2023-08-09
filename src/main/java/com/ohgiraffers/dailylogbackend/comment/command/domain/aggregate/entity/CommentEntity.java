package com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.entity;

import com.ohgiraffers.dailylogbackend.common.AuditingFields;
import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@ToString
@Setter
@NoArgsConstructor
public class CommentEntity extends AuditingFields {

    @Id
    @Column(name = "comment_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentNo;

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "comment_is_deleted")
    private DeleteEnum commentIsDeleted;

    @ManyToOne
    @JoinColumn(name = "diary_no")
    private DiaryEntity diaryNo;

    @ManyToOne
    @JoinColumn(name = "member_no")
    private MemberEntity memberNo;

    public CommentEntity(Long commentNo, String commentContent, DeleteEnum commentIsDeleted, DiaryEntity diaryNo, MemberEntity memberNo) {
        this.commentNo = commentNo;
        this.commentContent = commentContent;
        this.commentIsDeleted = commentIsDeleted;
        this.diaryNo = diaryNo;
        this.memberNo = memberNo;
    }
}
