package com.ohgiraffers.dailylogbackend.report.command.application.dto;

import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportStateEnum;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportTypeEnum;
import lombok.*;

@NoArgsConstructor
@Setter
@Getter
@ToString
public class ReportSaveDTO {

    private Long reportNo;
    private Long diaryNo;
    private Long commentNo;
    private Long reporterNo;
    private Long reporteeNo;
    private ReportTypeEnum reportType;
    private ReportStateEnum reportState;

    @Builder
    public ReportSaveDTO(Long reportNo, Long diaryNo, Long commentNo, Long reporterNo, Long reporteeNo, ReportTypeEnum reportType, ReportStateEnum reportState) { // 변경된 부분
        this.reportNo = reportNo;
        this.diaryNo = diaryNo;
        this.commentNo = commentNo;
        this.reporterNo = reporterNo;
        this.reporteeNo = reporteeNo;
        this.reportType = reportType;
        this.reportState = reportState;
    }
}

//    public static ReportSaveDTO fromEntity(ReportEntity reportEntity) {
//        return ReportSaveDTO.builder()
//                .reportNo(reportEntity.getReportNo())
//                .diaryNo(reportEntity.getDiaryNo())
//                .commentNo(reportEntity.getCommentNo())
//                .reporterNo(reportEntity.getReporterNo())
//                .reporteeNo(reportEntity.getReporteeNo())
//                .reportType(ReportTypeEnum.valueOf(reportEntity.getReportType()))
//                .reportState(reportEntity.getReportState())
//                .build();
//    }
