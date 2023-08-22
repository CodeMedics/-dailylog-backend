package com.ohgiraffers.dailylogbackend.report.command.domain.aggregate.vo;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Embeddable
@Getter
public class ReporterVO {
    @Column(name = "reporter_no", nullable = false)
    private Long No;

    public ReporterVO(Long no) {
        this.No = no;
    }

    protected ReporterVO() {

    }
}
