package com.ohgiraffers.dailylogbackend.member.command.application.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateMemberDTO {

    private String profileImage;
    private String nickname;

    public UpdateMemberDTO() {}

    public UpdateMemberDTO(String profileImage, String nickname) {
        this.profileImage = profileImage;
        this.nickname = nickname;
    }
}
