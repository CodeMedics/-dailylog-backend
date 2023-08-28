package com.ohgiraffers.dailylogbackend.file.command.infra.repository;

import com.ohgiraffers.dailylogbackend.file.command.domain.aggregate.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<FileEntity, Long> {

}
