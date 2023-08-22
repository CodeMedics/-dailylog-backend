package com.ohgiraffers.dailylogbackend.jwt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class TokenProvider {

        private static final Logger log = LoggerFactory.getLogger(TokenProvider.class);
        private static final String AUTHORITIES_KEY = "Auth";
        private static final String BEARER_TYPE = "bearer";
        private static final long ACCESS_TOKEN_EXPIRE_TIME = 1000 * 21599; // 토큰 만료 시간


}
