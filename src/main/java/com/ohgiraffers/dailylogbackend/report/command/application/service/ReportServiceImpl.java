package com.ohgiraffers.dailylogbackend.report.command.application.service;

import com.ohgiraffers.dailylogbackend.member.command.domain.repository.MemberRepository;
import com.ohgiraffers.dailylogbackend.report.command.application.dto.ReportSaveDTO;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportStateEnum;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.entity.ReportEntity;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.vo.ReporteeVO;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.vo.ReporterVO;
import com.ohgiraffers.dailylogbackend.report.command.domain.repository.ReportRepository;
import com.ohgiraffers.dailylogbackend.report.command.domain.service.ReportService;
import com.ohgiraffers.dailylogbackend.report.command.infra.service.RequestMemberServiceImpl;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReportServiceImpl implements ReportService {

    private final ReportRepository reportRepository;


    public ReportServiceImpl(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    @Transactional
    public ReportEntity saveReportDiary(ReportSaveDTO reportSaveDTO) {

//        boolean existed = requestMemberServiceImpl.checkNotNull(reportSaveDTO);
//        Optional<MemberEntity> reporteeMember = memberRepository.findByMemberNo(reportSaveDTO.getReporteeNo());

//        if (!reporteeMember.isPresent()) {
//            throw new RuntimeException("신고 대상이 없습니다.");
//        }

        ReportEntity reportEntity = ReportEntity.builder()
                .diaryNo(reportSaveDTO.getDiaryNo())
                .commentNo(reportSaveDTO.getCommentNo())
                .reporter(new ReporterVO(reportSaveDTO.getReporterNo()))
                .reportee(new ReporteeVO(reportSaveDTO.getReporteeNo()))
                .reportType(reportSaveDTO.getReportType())
                .reportState(reportSaveDTO.getReportState())
                .build();

        reportRepository.save(reportEntity);

        return reportEntity;
    }

    // 신고 처리 로직
    @Override
    @Transactional
    public void acceptReport(Long reportNo) {

        try {
            ReportEntity reportEntity = reportRepository.findById(reportNo)
                    .orElseThrow(() -> new NotFoundException("존재하지않는 신고입니다."));

            reportEntity.setReportState(ReportStateEnum.ACCEPT);

            reportRepository.save(reportEntity);

        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    // 신고 거절 로직
    @Override
    @Transactional
    public void declineReport(Long reportNo) {

        try {
            ReportEntity reportEntity = reportRepository.findById(reportNo)
                    .orElseThrow(() -> new NotFoundException("존재하지않는 신고입니다."));

            reportEntity.setReportState(ReportStateEnum.DECLINE);

            reportRepository.save(reportEntity);

        } catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

