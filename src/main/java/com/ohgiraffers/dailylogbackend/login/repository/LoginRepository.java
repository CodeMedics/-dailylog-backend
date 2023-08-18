package com.ohgiraffers.dailylogbackend.login.repository;

import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<MemberEntity, Long> {
}
