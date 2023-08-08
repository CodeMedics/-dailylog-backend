package com.ohgiraffers.dailylogbackend.file.command.domain.aggregate.entity;

import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.Member;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "file_no")
@Getter
public class FileEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long fileNo;

    @Column
    private String originFileName;

    @Column
    private String fileName;

    @Column
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "member_no")
    private Member member;

    @JoinColumn(name = "diary_no")
    private Long diaryNo;

    public FileEntity() {}

    public FileEntity(Long fileNo, String originFileName, String fileName, String filePath, Member member, Long diaryNo) {
        this.fileNo = fileNo;
        this.originFileName = originFileName;
        this.fileName = fileName;
        this.filePath = filePath;
        this.member = member;
        this.diaryNo = diaryNo;
    }
}
