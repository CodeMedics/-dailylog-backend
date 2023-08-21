package com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.vo;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Getter
@ToString
public class ReporteeVO {
    @Column(name = "reportee_no", nullable = false)
    private Long No;

    public ReporteeVO(Long no) {
        this.No = no;
    }

    public ReporteeVO() {

    }
}
