package com.ohgiraffers.dailylogbackend.file;

import com.ohgiraffers.dailylogbackend.file.command.domain.service.FileService;
import net.bytebuddy.asm.Advice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.Arguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class FileUploadTests {

    @Autowired
    private FileService fileService;

    private MockMultipartFile getMockUploadFile() throws IOException {
        return new MockMultipartFile("file", "file.jpg", "image/jpg", new FileInputStream("C:/Users/user/Desktop/kim.jpg"));
    }

    @Test
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
    public void deleteFile() throws Exception {
        // given
        String filePath = fileService.save(getMockUploadFile());
        fileService.delete(filePath);

        // then
        File file = new File(filePath);
        assertThat(file.exists()).isFalse();
    }
}
