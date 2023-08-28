package com.ohgiraffers.dailylogbackend.comment.command.infra.service;

import com.ohgiraffers.dailylogbackend.comment.command.application.dto.CommentSaveDTO;
import com.ohgiraffers.dailylogbackend.comment.command.application.dto.CommentUpdateDTO;
import com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.entity.CommentEntity;

public interface CommentService {

    //댓글 저장
    public void saveComment(CommentSaveDTO commentSaveDTO);

    //댓글 삭제
    public void deleteComment(CommentEntity commentEntity);

    //댓글 수정
    public void updateComment(Long diaryNo, CommentUpdateDTO commentUpdateDTO);





}
