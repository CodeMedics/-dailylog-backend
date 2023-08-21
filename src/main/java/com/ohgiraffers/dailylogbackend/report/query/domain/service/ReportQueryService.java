package com.ohgiraffers.dailylogbackend.report.query.domain.service;

import com.ohgiraffers.dailylogbackend.report.query.application.dto.ReportDiaryQueryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ReportQueryService {
    Page<ReportDiaryQueryDTO> getReportPage(Pageable pageable);
}
