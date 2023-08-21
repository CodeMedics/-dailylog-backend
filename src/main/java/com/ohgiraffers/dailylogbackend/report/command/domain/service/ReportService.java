package com.ohgiraffers.dailylogbackend.report.command.domain.service;

import com.ohgiraffers.dailylogbackend.report.command.application.dto.ReportSaveDTO;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.entity.ReportEntity;

public interface ReportService {

    ReportEntity saveReportDiary(ReportSaveDTO reportSaveDTO);
    void acceptReport(Long reportNo);
    void declineReport(Long reportNo);
}
