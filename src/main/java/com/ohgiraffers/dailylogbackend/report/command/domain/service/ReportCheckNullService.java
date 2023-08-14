package com.ohgiraffers.dailylogbackend.report.command.domain.service;

import com.ohgiraffers.dailylogbackend.report.command.application.dto.ReportDTO;

public interface ReportCheckNullService {

    boolean checkNotNull(ReportDTO diaryReportDTO);
}
