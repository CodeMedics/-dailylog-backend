package com.ohgiraffers.dailylogbackend.login.dto;

public class KakaoProfileDTO {

    private long id;
    private String connected_at;
    private KakaoAccount kakao_account;

    public KakaoProfileDTO() {}

    public KakaoProfileDTO(long id, String connected_at, KakaoAccount kakao_account) {
        this.id = id;
        this.connected_at = connected_at;
        this.kakao_account = kakao_account;
    }


}
