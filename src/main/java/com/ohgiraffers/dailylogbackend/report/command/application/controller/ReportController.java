package com.ohgiraffers.dailylogbackend.report.command.application.controller;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.diary.command.infra.repository.DiaryRepository;
import com.ohgiraffers.dailylogbackend.report.command.application.dto.ReportSaveDTO;
import com.ohgiraffers.dailylogbackend.report.command.application.service.ReportServiceImpl;
import com.ohgiraffers.dailylogbackend.report.command.domain.repository.ReportRepository;
import com.ohgiraffers.dailylogbackend.report.command.infra.service.RequestMemberServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ReportController {
    private final ReportServiceImpl reportServiceImpl;
    private final ReportRepository reportRepository;
    private final RequestMemberServiceImpl requestMemberServiceImpl;
    private final DiaryRepository diaryRepository;

    @Autowired
    public ReportController(ReportServiceImpl reportServiceImpl, ReportRepository reportRepository, RequestMemberServiceImpl requestMemberServiceImpl, DiaryRepository diaryRepository) {
        this.reportServiceImpl = reportServiceImpl;
        this.reportRepository = reportRepository;
        this.requestMemberServiceImpl = requestMemberServiceImpl;
        this.diaryRepository = diaryRepository;
    }

    // 일기 신고 등록
    @ResponseBody
    @PostMapping("/report/{diaryNo}")
    public ResponseEntity saveReport(@PathVariable("diaryNo") Long diaryNo, @RequestBody ReportSaveDTO reportSaveDTO) {

        Optional<DiaryEntity> diaryEntity = diaryRepository.findById(diaryNo);

        if (requestMemberServiceImpl.checkNotNull(reportSaveDTO)) {
            reportServiceImpl.saveReportDiary(reportSaveDTO);
        }
            return ResponseEntity.created(URI.create("/api/v1/report/" + diaryNo)).build();
    }

    // 일기 신고 처리(admin)
    @DeleteMapping("reportdiary/{reportNo}")
    public ResponseEntity acceptReport(@PathVariable Long reportNo) {
        try {
            reportServiceImpl.acceptReport(reportNo);
            return ResponseEntity.ok("신고가 처리되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("신고 처리에 실패하였습니다.");
        }
    }
}