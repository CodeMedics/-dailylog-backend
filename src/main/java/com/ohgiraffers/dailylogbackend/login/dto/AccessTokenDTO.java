package com.ohgiraffers.dailylogbackend.login.dto;

public class AccessTokenDTO {

    private String grantType;
    private Long MemberNo;
    private String accessToken;
    private long accessTokenExpiresIn;

    public AccessTokenDTO() {}

    public AccessTokenDTO(String grantType, Long memberNo, String accessToken, long accessTokenExpiresIn) {
        this.grantType = grantType;
        MemberNo = memberNo;
        this.accessToken = accessToken;
        this.accessTokenExpiresIn = accessTokenExpiresIn;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public Long getMemberNo() {
        return MemberNo;
    }

    public void setMemberNo(Long memberNo) {
        MemberNo = memberNo;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getAccessTokenExpiresIn() {
        return accessTokenExpiresIn;
    }

    public void setAccessTokenExpiresIn(long accessTokenExpiresIn) {
        this.accessTokenExpiresIn = accessTokenExpiresIn;
    }

    @Override
    public String toString() {
        return "AccessTokenDTO{" +
                "grantType='" + grantType + '\'' +
                ", MemberNo=" + MemberNo +
                ", accessToken='" + accessToken + '\'' +
                ", accessTokenExpiresIn=" + accessTokenExpiresIn +
                '}';
    }
}
