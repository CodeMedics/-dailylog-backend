package com.ohgiraffers.dailylogbackend.member.command.domain.repository;

import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.EnumType.SocialEnum;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    MemberEntity findByUID(String uid, SocialEnum social);

    List<Object> findByUID(Long memberNo);
}
