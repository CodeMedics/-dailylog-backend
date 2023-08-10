package com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.entity;

import com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.entity.Comment;
import com.ohgiraffers.dailylogbackend.common.AuditingFields;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "report")
@Setter
@Getter
public class ReportEntity extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportNo;

    @ManyToOne
    @JoinColumn(name = "diary_no")
    private DiaryEntity diary;

//    @ManyToOne
//    @JoinColumn(name = "comment_no")
//    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "reporter")

    private MemberEntity reporter;

    @ManyToOne
    @JoinColumn(name = "reportee")
    private MemberEntity reportee;


    @Column(name = "report_type")
    private Integer reportType;

    public ReportEntity() {}


    public ReportEntity(DiaryEntity diary, MemberEntity reporter, MemberEntity reportee, Integer reportType) {
        this.diary = diary;
//        this.comment = comment;
        this.reporter = reporter;
        this.reportee = reportee;
        this.reportType = reportType;
    }
}
