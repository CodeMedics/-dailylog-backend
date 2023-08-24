package com.ohgiraffers.dailylogbackend.feed.query.infra.mapper;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.feed.command.domain.aggregate.entity.FeedEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {

    List<FeedEntity> getFeedList();

}
