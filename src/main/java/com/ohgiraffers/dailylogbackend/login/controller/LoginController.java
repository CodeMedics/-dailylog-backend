package com.ohgiraffers.dailylogbackend.login.controller;

import com.ohgiraffers.dailylogbackend.common.ResponseMessage;
import com.ohgiraffers.dailylogbackend.login.dto.AccessTokenDTO;
import com.ohgiraffers.dailylogbackend.login.dto.OauthTokenDTO;
import com.ohgiraffers.dailylogbackend.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/login")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PreAuthorize("permitAll()")
    @PostMapping("/kakaocode")
    public ResponseEntity<?> getKakaoCode(@RequestBody Map<String, String> code) {

        OauthTokenDTO oauthToken = loginService.getAccessToken(code.get("code"));

        System.out.println(oauthToken.getAccess_token());

        AccessTokenDTO jwtToken = loginService.getJwtToken(oauthToken);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("token", jwtToken);

        return ResponseEntity
                .ok()
                .body(new ResponseMessage(200, "로그인 성공", responseMap));
    }

    @PostMapping("/renew")
    public ResponseEntity<?> renewAccessToken(@RequestHeader(value = "Auth") String auth) {

        System.out.println("auth = : " + auth);

        return null;
    }

}
