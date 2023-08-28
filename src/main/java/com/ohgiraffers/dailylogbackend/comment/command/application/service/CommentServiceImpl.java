package com.ohgiraffers.dailylogbackend.comment.command.application.service;

import com.ohgiraffers.dailylogbackend.comment.command.application.dto.CommentSaveDTO;
import com.ohgiraffers.dailylogbackend.comment.command.application.dto.CommentUpdateDTO;
import com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.entity.CommentEntity;
import com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.vo.CommentDiaryVO;
import com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.vo.CommentMemberVO;
import com.ohgiraffers.dailylogbackend.comment.command.domain.repository.CommentRepository;
import com.ohgiraffers.dailylogbackend.comment.command.infra.service.CommentService;
import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.diary.command.infra.repository.DiaryRepository;
import com.ohgiraffers.dailylogbackend.member.command.domain.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final DiaryRepository diaryRepository;
    private final MemberRepository memberRepository;

    public CommentServiceImpl(CommentRepository commentRepository, DiaryRepository diaryRepository, MemberRepository memberRepository) {
        this.commentRepository = commentRepository;
        this.diaryRepository = diaryRepository;
        this.memberRepository = memberRepository;
    }

    // 댓글 저장
    @Override
    @Transactional
    public void saveComment(CommentSaveDTO commentSaveDTO) {

        CommentDiaryVO diaryVO = new CommentDiaryVO(commentSaveDTO.getDiaryNo());
        CommentMemberVO memberVO = new CommentMemberVO(commentSaveDTO.getMemberNo());

        CommentEntity commentEntity = new CommentEntity(commentSaveDTO.getCommentNo(),commentSaveDTO.getCommentContent(), DeleteEnum.PRESENT, diaryVO, memberVO );

        commentRepository.save(commentEntity);
    }

    // 댓글 삭제 상태 변경
    @Override
    @Transactional
    public void deleteComment(CommentEntity commentEntity) {
        commentEntity.setCommentIsDeleted(DeleteEnum.DELETED);
    }

    // 댓글 수정
    @Transactional
    public void updateComment(Long diaryNo, CommentUpdateDTO commentUpdateDTO) {

        CommentEntity commentEntity = commentRepository.findByCommentDiaryVO_DiaryNo(diaryNo);

        commentEntity.setCommentContent(commentUpdateDTO.getCommentContent());
    }
}
