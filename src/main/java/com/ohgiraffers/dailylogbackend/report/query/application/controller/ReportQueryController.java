package com.ohgiraffers.dailylogbackend.report.query.application.controller;

import com.ohgiraffers.dailylogbackend.report.query.application.dto.ReportDiaryQueryDTO;
import com.ohgiraffers.dailylogbackend.report.query.application.service.ReportQueryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ReportQueryController {

    private final ReportQueryServiceImpl reportQueryService;

    @Autowired
    public ReportQueryController(ReportQueryServiceImpl reportQueryService) {
        this.reportQueryService = reportQueryService;
    }

    @GetMapping("/reportdiary")
    public ResponseEntity<Page<ReportDiaryQueryDTO>> getReportedDiaries(
            @PageableDefault(size = 10, direction = Sort.Direction.DESC) Pageable pageable) {

        Page<ReportDiaryQueryDTO> reportPage = reportQueryService.getReportPage(pageable);
        return ResponseEntity.ok(reportPage);
    }
}