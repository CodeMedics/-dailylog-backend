package com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity;

import com.ohgiraffers.dailylogbackend.common.AuditingFields;
import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.EnumType.GenderEnum;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.EnumType.Role;
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
    private Role role;

    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private SocialEnum socialLogin;

    @Column(nullable = false, name = "email")
    private String email;

    @Column(name = "sign_up_date", nullable = false)
    private LocalDate signUpDate;

    @Column(name = "deleted_date")
    private LocalDate deletedDate;

    @Column(name = "is_deleted", columnDefinition = "varchar (2)", nullable = false)
    private DeleteEnum isDeleted;

    @Column(name = "reported_count", nullable = false)
    private int reportedCount;

    @PrePersist
    public void prePersist() {
        isDeleted = DeleteEnum.PRESENT;
        reportedCount = 0;
        signUpDate = LocalDate.now();
    }

    @Builder
    public MemberEntity(Long memberNo, String UID, String nickname, String profileImage, GenderEnum gender, SocialEnum socialLogin, String email, Role role) {
        this.memberNo = memberNo;
        this.UID = UID;
        this.nickname = nickname;
        this.profileImage = profileImage;
        this.gender = gender;
        this.socialLogin = socialLogin;
        this.email = email;
        this.role = role;
    }

    public void setDeleteIf() {

        this.isDeleted = DeleteEnum.DELETED;
        this.deletedDate = LocalDate.now();
    }

    public MemberEntity(String uid, String nickname, String profileImage, SocialEnum socialLogin, DeleteEnum isDeleted) {
    }
}
