package com.ohgiraffers.dailylogbackend.report.declineReport;

import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import com.ohgiraffers.dailylogbackend.report.command.application.service.ReportServiceImpl;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportStateEnum;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.entity.ReportEntity;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.vo.ReporteeVO;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.vo.ReporterVO;
import com.ohgiraffers.dailylogbackend.report.command.domain.repository.ReportRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class declineReportTest {

    @Autowired
    private ReportRepository reportRepository;
    private ReportServiceImpl reportServiceImpl;

    @BeforeEach
    public void setUp() {
        reportServiceImpl = new ReportServiceImpl(reportRepository);
    }

    @Test
    @DisplayName("decline report test")
    public void testDeclineReport() {
        // Arrange
        MemberEntity reporter = MemberEntity.builder().memberNo(1L).build();
        MemberEntity reportee = MemberEntity.builder().memberNo(2L).build();

        ReporterVO reporterVO = new ReporterVO(reporter.getMemberNo());
        ReporteeVO reporteeVO = new ReporteeVO(reportee.getMemberNo());

        ReportEntity reportEntity = ReportEntity.builder()
                .reportNo(1L)
                .reporter(reporterVO)
                .reportee(reporteeVO)
                .build();

        reportRepository.save(reportEntity);
        Long reportNo = reportEntity.getReportNo();

        // Act
        ReportEntity reportToDecline = reportRepository.findById(reportNo).orElse(null);
        reportServiceImpl.declineReport(reportToDecline.getReportNo());

        // Assert
        ReportEntity declineReport = reportRepository.findById(reportNo).orElse(null);
        assertThat(declineReport).isNotNull();
        assertThat(declineReport.getReportState()).isEqualTo(ReportStateEnum.DECLINE);
    }
}
