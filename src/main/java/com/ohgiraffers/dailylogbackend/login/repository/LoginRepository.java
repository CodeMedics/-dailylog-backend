package com.ohgiraffers.dailylogbackend.login.repository;

import com.ohgiraffers.dailylogbackend.member.command.application.dto.CreateMemberDTO;
import com.ohgiraffers.dailylogbackend.member.command.application.dto.MemberDTO;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LoginRepository extends JpaRepository<MemberEntity, Long> {

    Optional<CreateMemberDTO> findByUID(String UID);
}
