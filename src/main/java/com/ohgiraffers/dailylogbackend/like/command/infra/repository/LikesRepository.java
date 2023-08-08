package com.ohgiraffers.dailylogbackend.like.command.infra.repository;

import com.ohgiraffers.dailylogbackend.like.command.domain.aggregate.entity.LikesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<LikesEntity, Long> {
    Optional<LikesEntity> findByDiaryIdAndUserId(Long diaryId, Long userId);
}
