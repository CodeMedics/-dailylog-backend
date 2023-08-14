package com.ohgiraffers.dailylogbackend.report.command.application.controller;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.diary.command.infra.repository.DiaryRepository;
import com.ohgiraffers.dailylogbackend.report.command.application.dto.ReportDTO;
import com.ohgiraffers.dailylogbackend.report.command.application.service.ReportServiceImpl;
import com.ohgiraffers.dailylogbackend.report.command.domain.repository.ReportRepository;
import com.ohgiraffers.dailylogbackend.report.command.domain.service.ReportCheckNullService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ReportController {
    private final ReportServiceImpl reportService;
    private final ReportRepository reportRepository;
    private final ReportCheckNullService reportCheckNullService;
    private final DiaryRepository diaryRepository;

    @Autowired
    public ReportController(ReportServiceImpl reportService, ReportRepository reportRepository, ReportCheckNullService reportCheckNullService, DiaryRepository diaryRepository) {
        this.reportService = reportService;
        this.reportRepository = reportRepository;
        this.reportCheckNullService = reportCheckNullService;
        this.diaryRepository = diaryRepository;
    }

    // 일기 신고 등록
    @ResponseBody
    @PostMapping("/report/{diaryNo}")
    public ResponseEntity saveReport(@PathVariable("diaryNo") Long diaryNo, @RequestBody ReportDTO reportDTO) {

        Optional<DiaryEntity> diaryEntity = diaryRepository.findById(diaryNo);

        if (reportCheckNullService.checkNotNull(reportDTO)) {
            String reporteeMemberId = reportDTO.getMemberNickname();   // 신고 된 사람의 닉네임..?
            reportService.saveReportDiary(reportDTO, reporteeMemberId, diaryEntity.get());
            // 추후 유저 존재하지 않을 시, 일기 존재하지 않을 시 로직 추가 예정
        }
            return ResponseEntity.created(URI.create("/api/v1/report/" + diaryNo)).build();
    }

    // 일기 신고 처리(admin)
    @DeleteMapping("reportdiary/{reportNo}")
    public ResponseEntity acceptReport(@PathVariable Long reportNo) {
        try {
            reportService.acceptReport(reportNo);
            return ResponseEntity.ok("신고가 처리되었습니다.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("신고 처리에 실패하였습니다.");
        }
    }
}