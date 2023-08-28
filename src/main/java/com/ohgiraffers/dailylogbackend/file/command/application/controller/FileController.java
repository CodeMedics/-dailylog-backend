//package com.ohgiraffers.dailylogbackend.file.command.application.controller;
//
//import com.ohgiraffers.dailylogbackend.file.command.domain.service.FileService;
//import com.ohgiraffers.dailylogbackend.file.command.domain.service.FileServiceImpl;
//import com.ohgiraffers.dailylogbackend.file.command.infra.repository.FileRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.FileInputStream;
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/api/files")
//public class FileController {
//
//    private final FileService fileService;
//
//    @Autowired
//    public FileController(FileService fileService) {
//        this.fileService = fileService;
//    }
//
//    @PostMapping("/upload")
//    public String uploadFile(@RequestParam("file") MultipartFile multipartFile) {
//        try {
//            String filePath = fileService.save(multipartFile);
//            return "File uploaded successfully. Path: " + filePath;
//        } catch (Exception e) {
//            return "File upload failed: " + e.getMessage();
//        }
//    }
//
//    @DeleteMapping("/delete")
//    public String deleteFile(@RequestParam("filePath") String filePath) {
//        try {
//            fileService.delete(filePath);
//            return "File deleted successfully.";
//        } catch (Exception e) {
//            return "File deletion failed: " + e.getMessage();
//        }
//    }
//}
