package com.ohgiraffers.dailylogbackend.diary.query.infra.mapper;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import org.apache.ibatis.annotations.Mapper;

import java.time.LocalDate;

@Mapper
public interface DiaryMapper {

    DiaryEntity getMyDiary(Long memberNo, LocalDate diaryDate);

    Long[] getFeedInputDiary();

}
