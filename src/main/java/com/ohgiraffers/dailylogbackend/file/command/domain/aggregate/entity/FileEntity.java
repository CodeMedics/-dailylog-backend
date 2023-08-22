package com.ohgiraffers.dailylogbackend.file.command.domain.aggregate.entity;

import com.ohgiraffers.dailylogbackend.common.AuditingFields;
import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.File;

@Entity
@Table(name = "file_no")
@Getter
public class FileEntity extends AuditingFields {

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
    private MemberEntity member;

    @ManyToOne
    @JoinColumn(name = "diary_no")
    private DiaryEntity diaryNo;

    @Column
    private DeleteEnum isDelete;

    public FileEntity() {}

    public FileEntity(Long fileNo, String originFileName, String fileName, String filePath, MemberEntity member,
                      DiaryEntity diaryNo, DeleteEnum isDelete) {
        this.fileNo = fileNo;
        this.originFileName = originFileName;
        this.fileName = fileName;
        this.filePath = filePath;
        this.member = member;
        this.diaryNo = diaryNo;
        this.isDelete = isDelete;
    }
}
