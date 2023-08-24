package com.ohgiraffers.dailylogbackend.feed.query.application.service;

import com.ohgiraffers.dailylogbackend.comment.command.domain.repository.CommentRepository;
import com.ohgiraffers.dailylogbackend.feed.command.domain.aggregate.entity.FeedEntity;
import com.ohgiraffers.dailylogbackend.feed.command.infra.repository.FeedRepository;
import com.ohgiraffers.dailylogbackend.feed.query.infra.mapper.FeedMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetFeedService {

    private final FeedMapper feedMapper;
    private final CommentRepository commentRepository;

    public GetFeedService(FeedMapper feedMapper, CommentRepository commentRepository) {
        this.feedMapper = feedMapper;
        this.commentRepository = commentRepository;
    }

    public List<FeedEntity> getFeedList() {

        List<FeedEntity> feedEntityList = feedMapper.getFeedList();

//        for (FeedEntity feedEntity: feedEntityList) {
//
//            feedEntity.getDiaryEntity().setCommentEntityList(commentRepository.getCommentEntityByDiaryNo(feedEntity.getDiaryEntity().getDiaryNo()));
//
//        }

        return feedEntityList;
    }


}
