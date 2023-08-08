package com.ohgiraffers.dailylogbackend.file.command.domain.aggregate.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "file_no")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id")
//    private Long MemberNo;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "diary_no")
//    private Long diaryNo;

}
