package com.ohgiraffers.dailylogbackend.file.command.domain.aggregate.entity;

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

    @JoinColumn(name = "member_no")
    private MemberNo memberNo;

    @JoinColumn(name = "diary_no")
    private Long diaryNo;

    public FileEntity() {}

    public FileEntity(Long fileNo, String originFileName, String fileName, String filePath, Long memberNo, Long diaryNo) {
        this.fileNo = fileNo;
        this.originFileName = originFileName;
        this.fileName = fileName;
        this.filePath = filePath;
        this.memberNo = memberNo;
        this.diaryNo = diaryNo;
    }
}
