package com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.entity;

import com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.entity.CommentEntity;
import com.ohgiraffers.dailylogbackend.common.AuditingFields;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportStateEnum;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportTypeEnum;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "report")
@Setter
public class ReportEntity extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportNo;

    @ManyToOne
    @JoinColumn(name = "diary_no")
    private DiaryEntity diaryNo;

    @ManyToOne
    @JoinColumn(name = "comment_no")
    private CommentEntity commentNo;

    @ManyToOne
    @JoinColumn(name = "reporter_no")
    private MemberEntity reporterNo;

    @ManyToOne
    @JoinColumn(name = "reportee_no")
    private MemberEntity reporteeNo;


    @Column(name = "report_type")
    private ReportTypeEnum reportType;

    @Column(name = "report_state")
    private ReportStateEnum reportState;

    public ReportEntity() {}

    public ReportEntity(DiaryEntity diaryNo, CommentEntity commentNo, MemberEntity reporterNo, MemberEntity reporteeNo, ReportTypeEnum reportType, ReportStateEnum reportState) {
        this.diaryNo = diaryNo;
        this.commentNo = commentNo;
        this.reporterNo = reporterNo;
        this.reporteeNo = reporteeNo;

        this.reportType = reportType;
        this.reportState = reportState;
    }
}
