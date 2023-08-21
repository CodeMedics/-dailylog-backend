package com.ohgiraffers.dailylogbackend.report.saveReport;

import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.repository.MemberRepository;
import com.ohgiraffers.dailylogbackend.report.command.application.dto.ReportSaveDTO;
import com.ohgiraffers.dailylogbackend.report.command.application.service.ReportServiceImpl;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportStateEnum;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.EnumType.ReportTypeEnum;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.entity.ReportEntity;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.vo.ReporteeVO;
import com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.vo.ReporterVO;
import com.ohgiraffers.dailylogbackend.report.command.domain.repository.ReportRepository;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class saveReportTest {

    @Mock
    private ReportRepository reportRepository;

    @Autowired
    private MemberRepository memberRepository;

    @InjectMocks
    private ReportServiceImpl reportServiceImpl;

//    @InjectMocks
//    private ReportController reportController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("report save test")
    public void testSaveReport() {
        // Arrange
        MemberEntity memberEntity = MemberEntity.builder()
                .memberNo(1L)
                .build();

        System.out.println("memberEntity getMemberNo = " + memberEntity.getMemberNo());

        ReportSaveDTO reportSaveDTO = ReportSaveDTO.builder()
                .diaryNo(1L)
                .reporterNo(memberEntity.getMemberNo())
                .reporteeNo(memberEntity.getMemberNo())
                .reportType(ReportTypeEnum.INAPPROPRIATE_NICKNAME)
                .reportState(ReportStateEnum.ACCEPT)
                .build();

        System.out.println("reportSaveDTO = " + reportSaveDTO);

        ReportEntity mockedReportEntity = ReportEntity.builder()
                .reportNo(1L)
                .diaryNo(reportSaveDTO.getDiaryNo())
                .reporter(new ReporterVO(reportSaveDTO.getReporterNo()))
                .reportee(new ReporteeVO(reportSaveDTO.getReporteeNo()))
                .reportType(reportSaveDTO.getReportType())
                .reportState(reportSaveDTO.getReportState())
                .build();

        System.out.println("mockedReportEntity = " + mockedReportEntity);

        when(reportRepository.save(any(ReportEntity.class))).thenReturn(mockedReportEntity);

        // Act
        ReportEntity saveReport = reportServiceImpl.saveReportDiary(reportSaveDTO);

        // Assert
        assertEquals(reportSaveDTO.getDiaryNo(), saveReport.getDiaryNo());
        assertEquals(reportSaveDTO.getReporterNo(), saveReport.getReporter().getNo());
        assertEquals(reportSaveDTO.getReporteeNo(), saveReport.getReportee().getNo());
        assertEquals(reportSaveDTO.getReportType(), saveReport.getReportType());  // 열거형 값을 문자열로 비교
        assertEquals(reportSaveDTO.getReportState(), saveReport.getReportState());  // 열거형 값을 문자열로 비교
    }
}
