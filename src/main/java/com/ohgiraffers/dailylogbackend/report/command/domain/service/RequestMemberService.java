package com.ohgiraffers.dailylogbackend.report.command.domain.service;

import com.ohgiraffers.dailylogbackend.report.command.application.dto.ReportSaveDTO;

public interface RequestMemberService {

    boolean checkNotNull(ReportSaveDTO reportSaveDTO);
}
