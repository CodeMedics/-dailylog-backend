package com.ohgiraffers.dailylogbackend.member.command.application.dto;

import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.EnumType.SocialEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class CreateMemberDTO implements UserDetails {

    private final String UID;
    private final String nickname;
    private final String profileImage;
    private final String accessToken;
    private final String refreshToken;
    private final SocialEnum socialLogin;
    private final DeleteEnum isDeleted;
    private Collection<? extends GrantedAuthority> authorities;


    public CreateMemberDTO(String UID, String nickname, String profileImage,
                           String accessToken, String refreshToken,
                           SocialEnum socialLogin, DeleteEnum isDeleted) {
        this.UID = UID;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
        this.socialLogin = socialLogin;
        this.isDeleted = isDeleted;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
