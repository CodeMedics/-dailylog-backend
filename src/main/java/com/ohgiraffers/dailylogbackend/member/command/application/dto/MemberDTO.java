package com.ohgiraffers.dailylogbackend.member.command.application.dto;

import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.EnumType.GenderEnum;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.EnumType.SocialEnum;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDTO {

    private Long memberNo;
    private String UID;
    private String nickname;
    private String profileImage;
    private GenderEnum gender;
    private SocialEnum socialLogin;
    private String email;
    private String accessToken;
    private long accessTokenExpireDate;
    private String refreshToken;
    private long refreshTokenExpireDate;
    private LocalDate signUpDate;
    private LocalDate deletedDate;
    private DeleteEnum isDeleted;
    private int reportedCount;

}
