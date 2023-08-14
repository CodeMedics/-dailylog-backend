package com.ohgiraffers.dailylogbackend.report.command.application.dto;

import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportStateEnum;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportTypeEnum;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.entity.ReportEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ReportDTO {

    private Long reportNo;
    private String memberNickname;
    private ReportTypeEnum reportType;
    private ReportStateEnum reportState;

    public static ReportDTO fromEntity(ReportEntity reportEntity) {

        return new ReportDTO(
                reportEntity.getReportNo(),
                reportEntity.getReporteeNo().getNickname(),
                reportEntity.getReportType(),
                reportEntity.getReportState());
    }
}
