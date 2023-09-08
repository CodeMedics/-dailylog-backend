package com.ohgiraffers.dailylogbackend.comment.command.domain.repository;

import com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.entity.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> getCommentEntityByDiaryNo(Long diaryNo);
}
