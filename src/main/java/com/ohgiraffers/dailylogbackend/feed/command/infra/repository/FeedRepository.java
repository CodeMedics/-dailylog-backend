package com.ohgiraffers.dailylogbackend.feed.command.infra.repository;

import com.ohgiraffers.dailylogbackend.feed.command.domain.aggregate.entity.FeedEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedRepository extends JpaRepository<FeedEntity, Long> {

}
