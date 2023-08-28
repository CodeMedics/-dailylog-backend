package com.ohgiraffers.dailylogbackend.login.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ohgiraffers.dailylogbackend.jwt.TokenProvider;
import com.ohgiraffers.dailylogbackend.login.dto.AccessTokenDTO;
import com.ohgiraffers.dailylogbackend.login.dto.KakaoProfileDTO;
import com.ohgiraffers.dailylogbackend.login.dto.OauthTokenDTO;
import com.ohgiraffers.dailylogbackend.login.dto.RenewTokenDTO;
import com.ohgiraffers.dailylogbackend.login.repository.LoginRepository;
import com.ohgiraffers.dailylogbackend.member.command.application.dto.MemberDTO;
import com.ohgiraffers.dailylogbackend.member.command.application.service.CreateMemberService;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.EnumType.SocialEnum;
import com.ohgiraffers.dailylogbackend.member.command.domain.service.MemberService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

import static com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.EnumType.SocialEnum.KAKAO;

@Service
public class LoginService {

    private final LoginRepository loginRepository;
    private final MemberService memberService;
    private TokenProvider tokenProvider;
    private ModelMapper modelMapper;


    @Autowired
    public LoginService(LoginRepository loginRepository, MemberService memberService, TokenProvider tokenProvider, ModelMapper modelMapper) {
        this.loginRepository = loginRepository;
        this.memberService = memberService;
        this.tokenProvider = tokenProvider;
        this.modelMapper = modelMapper;
    }

    public OauthTokenDTO getAccessToken(String code) {

        RestTemplate rt = new RestTemplate();
        rt.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        MultiValueMap<String , String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "authorization_code");
        // env 파일에서 kakao api 받아와서 key값 저장
        params.add("client_id", System.getenv("KakaoRestAPIKey"));
//        params.add("redirect_uri", "http://harulog.site/oauth");
        // 첨부할 사이트
        params.add("code", code);

        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
                new HttpEntity<>(params, headers);

        ResponseEntity<String> accessTokenResponse = rt.exchange(
                "https://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        OauthTokenDTO oauthToken = null;

        try {
            oauthToken = objectMapper.readValue(accessTokenResponse.getBody(), OauthTokenDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return oauthToken;
    }

    public KakaoProfileDTO findKakaoProfile(String accessToken) {

        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Bearer" + accessToken);
        headers.add("Content-type", "application/x-www-form-urlencoded;charset=utf-8");

        HttpEntity<MultiValueMap<String, String>> kakaoProfileRequest =
                new HttpEntity<>(headers);

        ResponseEntity<String> kakaoProfileResponse = rt.exchange(
                "http://kapi.kakao.com/v2/user/me",
                HttpMethod.POST,
                kakaoProfileRequest,
                String.class
        );

        KakaoProfileDTO kakaoProfileDTO = new KakaoProfileDTO();
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            kakaoProfileDTO = objectMapper.readValue(kakaoProfileResponse.getBody(), KakaoProfileDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return kakaoProfileDTO;
    }

    public RenewTokenDTO renewKakaoToken(MemberDTO foundMember) {
        RestTemplate rt = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("Context-type", "application/x-www-form-unlencoded;charset=utf-8");

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "refresh_token");
        params.add("client_id", System.getenv("KakaoRestAPIkey"));
        params.add("refresh_token", foundMember.getRefreshToken());

        HttpEntity<MultiValueMap<String, String>> kakaoTokenRequest =
                new HttpEntity<>(params, headers);

        ResponseEntity<String> renewTokenResponse = rt.exchange(
                "http://kauth.kakao.com/oauth/token",
                HttpMethod.POST,
                kakaoTokenRequest,
                String.class
        );

        ObjectMapper objectMapper = new ObjectMapper();
        RenewTokenDTO renewToken = null;

        try {
            renewToken = objectMapper.readValue(renewTokenResponse.getBody(), RenewTokenDTO.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return renewToken;
    }

    public AccessTokenDTO getJwtToken(OauthTokenDTO oauthToken) {

        KakaoProfileDTO kakaoProfileDTO = findKakaoProfile(oauthToken.getAccess_token());

        MemberDTO foundMember = new MemberDTO();

        if(memberService.findByUID(KAKAO.name(), String.valueOf(kakaoProfileDTO.getUID())) == null) {
            MemberDTO newMember = new MemberDTO();

            newMember.setSocialLogin(KAKAO);
            newMember.setUID(String.valueOf(kakaoProfileDTO.getUID()));
            newMember.setEmail(kakaoProfileDTO.getKakao_account().getEmail());
            newMember.setRefreshToken(oauthToken.getRefresh_token());
            newMember.setAccessToken(oauthToken.getAccess_token());
            newMember.setSignUpDate(LocalDate.now());
            newMember.setRefreshTokenExpireDate(oauthToken.getRefresh_token_expires_in() + System.currentTimeMillis());
            newMember.setAccessTokenExpireDate(oauthToken.getExpires_in() + System.currentTimeMillis());
            newMember.setProfileImage("https://api.dicebear.com/6.x/thumbs/svg?seed=" + newMember.getEmail().split("@")[0]);

            memberService.registNewMember(newMember);
        }

        foundMember = memberService.findByUID(KAKAO.name(), String.valueOf(kakaoProfileDTO.getUID()));

        foundMember.setRefreshToken(oauthToken.getRefresh_token());
        foundMember.setAccessToken(oauthToken.getAccess_token());
        foundMember.setRefreshTokenExpireDate(oauthToken.getRefresh_token_expires_in() + System.currentTimeMillis());
        foundMember.setAccessTokenExpireDate(oauthToken.getExpires_in() + System.currentTimeMillis());

        return tokenProvider.generateMemberToken(foundMember);
    }
}
