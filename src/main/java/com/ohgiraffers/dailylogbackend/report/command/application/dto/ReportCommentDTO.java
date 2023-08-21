package com.ohgiraffers.dailylogbackend.report.command.application.dto;

import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportStateEnum;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportTypeEnum;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ReportCommentDTO {

    private Long commentReportNo;
    private String memberNickname;
    private ReportTypeEnum reportType;
    private ReportStateEnum reportState;


}
