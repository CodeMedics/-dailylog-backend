package com.ohgiraffers.dailylogbackend.report.query.application.service;

import com.ohgiraffers.dailylogbackend.report.query.application.dto.ReportDiaryQueryDTO;
import com.ohgiraffers.dailylogbackend.report.query.domain.service.ReportQueryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ReportQueryServiceImpl implements ReportQueryService {
    @Override
    public Page<ReportDiaryQueryDTO> getReportPage(Pageable pageable) {
        return null;
    }
}
