package com.ohgiraffers.dailylogbackend.like.command.infra.repository;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.like.command.domain.aggregate.entity.LikesEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<LikesEntity, Long> {
    Optional<LikesEntity> findByMemberAndDiary(MemberEntity member, DiaryEntity diary);
}
