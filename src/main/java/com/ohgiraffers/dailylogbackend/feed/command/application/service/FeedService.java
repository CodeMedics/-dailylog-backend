package com.ohgiraffers.dailylogbackend.feed.command.application.service;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.diary.query.application.service.GetDiaryService;
import com.ohgiraffers.dailylogbackend.feed.command.domain.aggregate.entity.FeedEntity;
import com.ohgiraffers.dailylogbackend.feed.command.infra.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FeedService {

    private final FeedRepository feedRepository;
    private final GetDiaryService getDiaryService;

    @Autowired
    public FeedService(FeedRepository feedRepository, GetDiaryService getDiaryService) {
        this.feedRepository = feedRepository;
        this.getDiaryService = getDiaryService;
    }

    public List<FeedEntity> createFeed() {

        List<FeedEntity> feedEntityList = new ArrayList<>();

        for(Long diaryNo : getDiaryService.getFeedInputDiary()) {
            feedEntityList.add(new FeedEntity(new DiaryEntity(diaryNo)));
        }

        return feedRepository.saveAll(feedEntityList);
    }


}
