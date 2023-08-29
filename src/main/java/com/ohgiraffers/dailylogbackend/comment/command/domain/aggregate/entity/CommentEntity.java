package com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.entity;

import com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.vo.CommentDiaryVO;
import com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.vo.CommentMemberVO;
import com.ohgiraffers.dailylogbackend.common.AuditingFields;
import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class CommentEntity extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_no")
    private Long commentNo;

    @Column(name = "comment_content")
    private String commentContent;

    @Column(name = "comment_is_deleted")
    @Enumerated(EnumType.STRING)
    private DeleteEnum commentIsDeleted;


    @ManyToOne
    @JoinColumn(name = "diary_no")
    private DiaryEntity diaryNo;


    @Embedded
    private CommentMemberVO commentMemberVO;


    public CommentEntity(Long commentNo, String commentContent, DeleteEnum commentIsDeleted, DiaryEntity commentDiaryVO, CommentMemberVO commentMemberVO) {
        this.commentNo = commentNo;
        this.commentContent = commentContent;
        this.commentIsDeleted = commentIsDeleted;
        this.diaryNo = commentDiaryVO;
        this.commentMemberVO = commentMemberVO;
    }

    // 삭제 (상태 변환) 메소드
    public void setCommentIsDeleted(DeleteEnum deleteEnum){

        this.commentIsDeleted = deleteEnum;
    }


}
