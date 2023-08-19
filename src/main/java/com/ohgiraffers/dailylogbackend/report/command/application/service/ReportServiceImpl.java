package com.ohgiraffers.dailylogbackend.report.command.application.service;

import com.ohgiraffers.dailylogbackend.member.command.domain.repository.MemberRepository;
import com.ohgiraffers.dailylogbackend.report.command.application.dto.ReportSaveDTO;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportStateEnum;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.entity.ReportEntity;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.vo.ReporteeVO;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.vo.ReporterVO;
import com.ohgiraffers.dailylogbackend.report.command.domain.repository.ReportRepository;
import com.ohgiraffers.dailylogbackend.report.command.domain.service.ReportService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class ReportServiceImpl implements ReportService {

    private final MemberRepository memberRepository;
    private final ReportRepository reportRepository;

//    private final RequstMemberService requstMemberService;

    public ReportServiceImpl(MemberRepository memberRepository, ReportRepository reportRepository) {
        this.memberRepository = memberRepository;
        this.reportRepository = reportRepository;
    }

    @Override
    @Transactional
    public ReportEntity saveReportDiary(ReportSaveDTO reportSaveDTO) {

//        boolean existed = requstMemberService.existMemberById();
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

    @Override
    @Transactional
    public void acceptReport(Long reportNo) {
        Optional<ReportEntity> optionalReportEntity = reportRepository.findById(reportNo);

        if (optionalReportEntity.isPresent()) {
            ReportEntity reportEntity = optionalReportEntity.get();

            if (reportEntity.getReportState() != ReportStateEnum.PENDING) {
                throw new RuntimeException("신고 상태가 PENDING이 아닙니다. 신고를 처리할 수 없습니다.");
            }

            reportEntity.setReportState(ReportStateEnum.ACCEPT);
            reportRepository.save(reportEntity);
        } else {
            throw new RuntimeException("신고 번호를 찾을 수 없습니다.");
        }
    }
}
