package com.ohgiraffers.dailylogbackend.declaration.command.domain.aggregate.entity;

import com.ohgiraffers.dailylogbackend.common.AuditingFields;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import lombok.Getter;
import javax.persistence.*;

@Entity
@Table(name = "report")
@Getter
public class Report extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long reportNo;

    @JoinColumn(name = "diary_no")
    private DiaryEntity diary;

    @JoinColumn(name = "comment_no")
    private Comment comment;

    @JoinColumn(name = "no")
    private MemberEntity reporter;

    @JoinColumn(name = "no")
    private MemberEntity reportee;

    @Column(name = "report_type")
    private Integer reportType;

    public Report() {}

    public Report(DiaryEntity diary, Comment comment, MemberEntity reporter, MemberEntity reportee, Integer reportType) {
        this.diary = diary;
        this.comment = comment;
        this.reporter = reporter;
        this.reportee = reportee;
        this.reportType = reportType;
    }
}
