package com.ohgiraffers.dailylogbackend.member.command.domain.repository;

import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findByMemberNo(String reporteeMemberId);
}
