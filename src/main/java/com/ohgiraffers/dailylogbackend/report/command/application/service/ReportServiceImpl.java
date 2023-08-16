package com.ohgiraffers.dailylogbackend.report.command.application.service;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.repository.MemberRepository;
import com.ohgiraffers.dailylogbackend.report.command.application.dto.ReportDTO;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportStateEnum;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.entity.ReportEntity;
import com.ohgiraffers.dailylogbackend.report.command.domain.repository.ReportRepository;
import com.ohgiraffers.dailylogbackend.report.command.domain.service.ReportService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
public class ReportServiceImpl implements ReportService {

    private final MemberRepository memberRepository;
    private final ReportRepository reportRepository;

    public ReportServiceImpl(MemberRepository memberRepository, ReportRepository reportRepository) {
        this.memberRepository = memberRepository;
        this.reportRepository = reportRepository;
    }

    @Override
    @Transactional
    public void saveReportDiary(ReportDTO reportDTO, String reporteeMemberId, DiaryEntity diaryEntity) {

        Optional<MemberEntity> reporteeMember = memberRepository.findByMemberNo(reporteeMemberId);

        ReportEntity reportEntity = new ReportEntity();
        reportEntity.setDiaryNo(diaryEntity);
        reportEntity.setReporteeNo(reporteeMember.orElse(null));
        reportEntity.setReportType(reportDTO.getReportType());
        reportEntity.setReportState(ReportStateEnum.PENDING);

        reportRepository.save(reportEntity);
    }

    @Override
    @Transactional
    public void acceptReport(Long reportNo) {

        Optional<ReportEntity> optionalReportEntity = reportRepository.findById(reportNo);

        if(optionalReportEntity.isPresent()) {
            ReportEntity reportEntity = optionalReportEntity.get();
            reportEntity.setReportState(ReportStateEnum.ACCEPT);
            reportRepository.save(reportEntity);

            if(reportEntity.getReportState() == ReportStateEnum.DECLINE) {
                throw new RuntimeException("신고 처리가 거절되었습니다.");
            }
        } else {
            throw new RuntimeException("신고 번호를 찾을 수 없습니다.");
        }
    }
}
