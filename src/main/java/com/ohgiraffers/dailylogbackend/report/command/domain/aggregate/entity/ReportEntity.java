package com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.entity;

import com.ohgiraffers.dailylogbackend.common.AuditingFields;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportStateEnum;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportTypeEnum;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.vo.ReporteeVO;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.vo.ReporterVO;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name = "report")
@Getter
@ToString
public class ReportEntity extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportNo;

    @JoinColumn(name = "diary_no")
    private Long diaryNo;

    @JoinColumn(name = "comment_no")
    private Long commentNo;

    @Embedded
    private ReporterVO reporter;

    @Embedded
    private ReporteeVO reportee;

    @Column(name = "report_type")
    @Enumerated(EnumType.STRING)
    private ReportTypeEnum reportType;

    @Column(name = "report_state")
    @Enumerated(EnumType.STRING)
    private ReportStateEnum reportState;


    @Builder
    public ReportEntity(Long reportNo, Long diaryNo, Long commentNo, ReporterVO reporter, ReporteeVO reportee, ReportTypeEnum reportType, ReportStateEnum reportState) {
        this.reportNo = reportNo;
        this.diaryNo = diaryNo;
        this.commentNo = commentNo;
        this.reporter = reporter;
        this.reportee = reportee;
        this.reportType = reportType;
        this.reportState = reportState != null ? reportState : ReportStateEnum.PENDING;
    }

    public ReportEntity() {

    }


    @PrePersist
    public void prePersist() {
        reportState = ReportStateEnum.PENDING;
    }

    public void setReportState(ReportStateEnum reportState) {
        this.reportState = reportState;
    }
}



