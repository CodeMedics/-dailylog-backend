package com.ohgiraffers.dailylogbackend.file;

import com.ohgiraffers.dailylogbackend.file.command.domain.service.FileService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class FileServiceTests {

    @Autowired
    private FileService fileService;

    private MockMultipartFile getMockUploadFile() throws IOException {
        return new MockMultipartFile("file", "file.jpg", "image/jpg", new FileInputStream("C:/Users/user/Desktop/files/kim.jpg"));
    }

    @Test
    @DisplayName("파일 저장 성공!")
    public void saveFile() throws Exception {
        // given
        String filePath = fileService.save(getMockUploadFile());

        // then
        File file = new File(filePath);
        assertThat(file.exists()).isTrue();

        // finally
        file.delete();
    }

    @Test
    @DisplayName("파일 삭제 성공!")
    public void deleteFile() throws Exception {
        // given
        String filePath = fileService.save(getMockUploadFile());
        fileService.delete(filePath);

        // then
        File file = new File(filePath);
        assertThat(file.exists()).isFalse();
    }
}
