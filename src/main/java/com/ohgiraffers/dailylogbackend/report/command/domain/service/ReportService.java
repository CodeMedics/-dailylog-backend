package com.ohgiraffers.dailylogbackend.report.command.domain.service;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.report.command.application.dto.ReportDTO;

public interface ReportService {

    void saveReportDiary(ReportDTO reportDTO, String memberNickname, DiaryEntity diaryEntity);

    void acceptReport(Long reportNo);
}
