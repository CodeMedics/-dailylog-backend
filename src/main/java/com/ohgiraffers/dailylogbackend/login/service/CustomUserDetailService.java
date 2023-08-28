package com.ohgiraffers.dailylogbackend.login.service;

import com.ohgiraffers.dailylogbackend.jwt.Exception.UserNotFoundException;
import com.ohgiraffers.dailylogbackend.login.repository.LoginRepository;
import com.ohgiraffers.dailylogbackend.member.command.application.dto.CreateMemberDTO;
import com.ohgiraffers.dailylogbackend.member.command.application.dto.MemberDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.Arrays;

@Service
public class CustomUserDetailService implements UserDetailsService {

    private static final Logger log = LoggerFactory.getLogger(CustomUserDetailService.class);

    private final LoginRepository loginRepository;

    public CustomUserDetailService(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String UID) throws UsernameNotFoundException {

        log.info("[CustomUserDetailService]=============================");
        log.info("[CustomUserDetailService] loadUserByUserId{}", UID);

        return loginRepository.findByUID(UID)
                .map(user -> addAuthorities(user))
                .orElseThrow(() -> new UserNotFoundException(UID + "찾을 수 없습니다."));
    }




}
