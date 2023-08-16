package com.ohgiraffers.dailylogbackend.file.command.application.dto;

import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import lombok.*;
import org.hibernate.sql.Delete;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class FileDTO {

    private Long fileNo;
    private String originFileName;
    private String fileName;
    private String filePath;
    private MemberEntity member;
    private DiaryEntity diaryNo;
    private DeleteEnum isDelete;

}
