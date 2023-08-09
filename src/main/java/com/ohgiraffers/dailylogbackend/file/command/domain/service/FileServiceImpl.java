package com.ohgiraffers.dailylogbackend.file.command.domain.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileServiceImpl implements FileService{
    @Override
    public String save(MultipartFile multipartFile){
        return null;
    }

    @Override
    public void delete(String filePath) {

    }
}
