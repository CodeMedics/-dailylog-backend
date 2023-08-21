package com.ohgiraffers.dailylogbackend.login.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class KakaoProfileDTO {

    private Long UID;
    private String connected_at;
    private KakaoAccount kakao_account;

    public KakaoProfileDTO() {}


}
