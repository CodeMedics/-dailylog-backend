package com.ohgiraffers.dailylogbackend.diary.command.infra.repository;

import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import org.hibernate.annotations.SQLDelete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DiaryRepository extends JpaRepository<DiaryEntity, Long> {

//    @Modifying      // @Modifying 어노테이션을 붙여야 update, delete 쿼리를 실행할 수 있다.
//    @Query("DELETE FROM DiaryEntity d WHERE d.memberEntity.memberNo = :memberNo")
//    void deleteByMemberNo(Long memberNo);

    @Modifying
    void deleteAllByMemberEntity(MemberEntity memberEntity);

}
