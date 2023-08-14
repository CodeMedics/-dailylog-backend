package com.ohgiraffers.dailylogbackend.report.command.infra.service;

import com.ohgiraffers.dailylogbackend.report.command.application.dto.ReportDTO;
import com.ohgiraffers.dailylogbackend.report.command.domain.service.ReportCheckNullService;
import org.springframework.stereotype.Service;

@Service
public class ReportCheckNullServiceImpl implements ReportCheckNullService {
    @Override
    public boolean checkNotNull(ReportDTO reportDiaryDTO) {

        return false;
    }
}
