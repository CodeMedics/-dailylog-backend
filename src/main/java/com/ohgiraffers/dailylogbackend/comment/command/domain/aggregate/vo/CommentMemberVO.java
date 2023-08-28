package com.ohgiraffers.dailylogbackend.comment.command.domain.aggregate.vo;


import lombok.Getter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@ToString
public class CommentMemberVO {

    @Column(name = "member_no")
    private Long memberNo;

    @Column(name = "nickname")
    private String nickname;

    public CommentMemberVO(Long memberNo, String nickname) {
        this.memberNo = memberNo;
        this.nickname = nickname;
    }

    public CommentMemberVO() {

    }
}
