package com.ohgiraffers.dailylogbackend.report.command.application.dto;

import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportStateEnum;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportTypeEnum;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class reportDTO {

    private Long reportNo;
    private Long diaryNo;
    private Long commentNo;
    private Long reporterNo;
    private Long reporteeNo;
    private ReportTypeEnum reportType;
    private ReportStateEnum reportState;

}
