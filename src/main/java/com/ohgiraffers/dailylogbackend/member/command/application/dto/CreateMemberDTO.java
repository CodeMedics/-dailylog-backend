package com.ohgiraffers.dailylogbackend.member.command.application.dto;

import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.EnumType.SocialEnum;
import lombok.Getter;

@Getter
public class CreateMemberDTO {

    private final String UID;
    private final String nickname;
    private final String profileImage;
    private final String accessToken;
    private final String refreshToken;
    private final SocialEnum social;
    private final DeleteEnum isDeleted;

    public CreateMemberDTO(String UID, String nickname, String profileImage,
                           String accessToken, String refreshToken,
                           SocialEnum social, DeleteEnum isDeleted) {
        this.UID = UID;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.social = social;
        this.isDeleted = isDeleted;
    }
}
