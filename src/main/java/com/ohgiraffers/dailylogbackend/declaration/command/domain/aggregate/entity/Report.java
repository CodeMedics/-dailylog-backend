package com.ohgiraffers.dailylogbackend.declaration.command.domain.aggregate.entity;

import lombok.Getter;
import javax.persistence.*;

@Entity
@Table(name = "report")
@Getter
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long reportNo;

    @JoinColumn(name = "diary_no")
    private Diary diary;

    @JoinColumn(name = "comment_no")
    private Comment comment;

    @Column
    private String reportedMember;

    @Column
    private String reportMember;

    @Column(name = "report_type")
    private Integer reportType;

    public Report() {}

    public Report(Diary diary, Comment comment, String reportedMember, String reportMember, Integer reportType) {
        this.diary = diary;
        this.comment = comment;
        this.reportedMember = reportedMember;
        this.reportMember = reportMember;
        this.reportType = reportType;
    }

}
