package com.ohgiraffers.dailylogbackend.declaration.command.domain.aggregate.entity;

import com.ohgiraffers.dailylogbackend.common.AuditingFields;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.Member;
import lombok.Getter;
import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "report")
@Getter
public class Report extends AuditingFields {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long reportNo;

    @JoinColumn(name = "diary_no")
    private DiaryEntity diary;

    @JoinColumn(name = "comment_no")
    private Comment comment;

    @JoinColumn(name = "no")
    private Member reporter;

    @JoinColumn(name = "no")
    private Member reportee;

    @Column(name = "report_type")
    private Integer reportType;

    public Report() {}

    public Report(DiaryEntity diary, Comment comment, Member reporter, Member reportee, Integer reportType) {
        this.diary = diary;
        this.comment = comment;
        this.reporter = reporter;
        this.reportee = reportee;
        this.reportType = reportType;
    }
}
