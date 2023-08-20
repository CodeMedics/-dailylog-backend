package com.ohgiraffers.dailylogbackend.report.command.infra.service;

import com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.entity.CommentEntity;
import com.ohgiraffers.dailylogbackend.comment.command.domain.repository.CommentRepository;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.repository.MemberRepository;
import com.ohgiraffers.dailylogbackend.report.command.application.dto.ReportSaveDTO;
import com.ohgiraffers.dailylogbackend.report.command.domain.service.RequestMemberService;
import org.apache.ibatis.javassist.NotFoundException;
import org.springframework.stereotype.Service;


@Service
public class RequestMemberServiceImpl implements RequestMemberService {

    private final MemberRepository memberRepository;
    private final CommentRepository commentRepository;

    public RequestMemberServiceImpl(MemberRepository memberRepository, CommentRepository commentRepository) {
        this.memberRepository = memberRepository;
        this.commentRepository = commentRepository;
    }

    // 피신고자, 댓글 NULL CHECK
    @Override
    public boolean checkNotNull(ReportSaveDTO reportSaveDTO) {

        try {
            MemberEntity memberEntity = memberRepository.findById(reportSaveDTO.getReporteeNo())
                    .orElseThrow(() -> new NotFoundException("존재하지 않는 회원입니다."));

            CommentEntity commentEntity = commentRepository.findById(reportSaveDTO.getCommentNo())
                    .orElseThrow(() -> new NotFoundException("존재하지 않는 댓글입니다."));

            return true;
        }
        catch (NotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
