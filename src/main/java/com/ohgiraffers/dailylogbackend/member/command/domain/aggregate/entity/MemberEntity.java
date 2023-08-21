package com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity;

import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.EnumType.GenderEnum;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.EnumType.SocialEnum;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "Member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member")
@SequenceGenerator(
        name = "member_sequence_generator",
        sequenceName = "sequence_member_no",
        initialValue = 1,
        allocationSize = 50
)
public class MemberEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "member_sequence_generator"
    )
    @Column(name = "member_no")
    private Long memberNo;

    @Column(name = "uid", nullable = false)
    private String UID;

    @Column(name = "member_nickname", unique = true, nullable = false)
    private String nickname;

    @Column(name = "profile_image", length = 100)
    private String profileImage;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SocialEnum social;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(name = "access_token", nullable = false)
    private String accessToken;

    @Column(name = "access_token_expire_date", nullable = false)
    private long accessTokenExpireDate;

    @Column(name = "refresh_token", nullable = false)
    private String refreshToken;

    @Column(name = "refresh_token_expire_date", nullable = false)
    private long refreshTokenExpireDate;

    @Column(name = "sign_up_date", nullable = false)
    private LocalDate signUpDate;

    @Column(name = "deleted_date")
    private LocalDate deletedDate;

    @Column(name = "is_deleted", columnDefinition = "varchar (2)", nullable = false)
    private DeleteEnum isDeleted;

    @Column(name = "reported_count", nullable = false)
    private int reportedCount;

    @Builder
    public MemberEntity(Long memberNo, String UID, String nickname, String profileImage, GenderEnum gender, SocialEnum social, String email, String accessToken, long accessTokenExpireDate, String refreshToken, long refreshTokenExpireDate) {
        this.memberNo = memberNo;
        this.UID = UID;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.gender = gender;
        this.social = social;
        this.email = email;
        this.accessToken = accessToken;
        this.accessTokenExpireDate = accessTokenExpireDate;
        this.refreshToken = refreshToken;
        this.refreshTokenExpireDate = refreshTokenExpireDate;
    }

    public void setDeleteIf() {
        this.isDeleted = DeleteEnum.DELETED;
    }
}

