package com.ohgiraffers.dailylogbackend.file.command.domain.service;

import com.ohgiraffers.dailylogbackend.file.command.infra.repository.FileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class FileServiceImpl implements FileService{

    private final FileRepository fileRepository;
    private final String fileDir;

    @Autowired
    public FileServiceImpl(FileRepository fileRepository, @Value("./src/testImg") String fileDir) {
        this.fileRepository = fileRepository;
        this.fileDir = fileDir;
    }

    @Override
    @Transactional
    public String save(MultipartFile multipartFile)  {


        int extIdx = multipartFile.getOriginalFilename().lastIndexOf(".");
        String extension = multipartFile.getOriginalFilename().substring(extIdx+1);

        String filePath = fileDir + UUID.randomUUID()+"."+extension;
        try {
            multipartFile.transferTo(new File(filePath));
        }catch (IOException e){

            throw new IllegalArgumentException("파일 저장 실패");
        }

        return filePath;
    }

    @Override
    @Transactional
    public void delete(String filePath) {
        File file = new File(filePath);

        if(!file.exists()) return;

        if(!file.delete()) throw new IllegalArgumentException("파일 삭제 실패");

    }
}
