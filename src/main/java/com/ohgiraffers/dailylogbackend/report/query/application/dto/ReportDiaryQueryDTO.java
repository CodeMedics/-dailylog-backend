package com.ohgiraffers.dailylogbackend.report.query.application.dto;

import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportStateEnum;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportTypeEnum;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class ReportDiaryQueryDTO {

    private Long reportNo;  // 신고 번호
    private Long diaryNo;   // 신고된 일기 번호
    private int reportCnt;  // 신고 횟수
    private Long reporterMemberNo;  // 신고자
    private Long reporteeMemberNo;  // 피신고자
    private String memberNickname;  // 닉네임...? 둘 다??
    private String diaryContent;    // 신고된 일기 내용
    private ReportTypeEnum reportType;  // 신고 유형
    private ReportStateEnum reportState;    // 신고 상태

}
