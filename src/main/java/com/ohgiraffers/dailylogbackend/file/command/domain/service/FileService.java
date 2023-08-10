package com.ohgiraffers.dailylogbackend.file.command.domain.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {

    String save(MultipartFile multipartFile) throws IOException;

    void delete(String filePath);
}
