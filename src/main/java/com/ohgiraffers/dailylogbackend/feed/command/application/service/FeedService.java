package com.ohgiraffers.dailylogbackend.feed.command.application.service;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.feed.command.domain.aggregate.entity.FeedEntity;
import com.ohgiraffers.dailylogbackend.feed.command.infra.repository.FeedRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedService {

    private final FeedRepository feedRepository;

    public FeedService(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    public List<FeedEntity> createFeed(List<DiaryEntity> diaryIdList) {

        List<FeedEntity> feedEntityList =  new ArrayList<>();

        for (DiaryEntity diaryEntity : diaryIdList) {
            FeedEntity feedEntity = new FeedEntity(diaryEntity);


            feedEntityList.add(feedRepository.save(feedEntity));
        }


        return feedEntityList;
    }
}
