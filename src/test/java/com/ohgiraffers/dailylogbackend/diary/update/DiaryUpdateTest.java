package com.ohgiraffers.dailylogbackend.diary.update;

import com.ohgiraffers.dailylogbackend.diary.command.application.dto.DiaryUpdateDTO;
import com.ohgiraffers.dailylogbackend.diary.command.application.service.DiaryServiceImpl;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.diary.command.infra.repository.DiaryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DiaryUpdateTest {

    @Autowired
    private DiaryServiceImpl diaryServiceImpl;

    @Autowired
    private DiaryRepository diaryRepository;

    @Test
    @DisplayName("diary update test")
    public void diaryUpdateTest() {
        // Arrange

        DiaryUpdateDTO diaryUpdateDTO = new DiaryUpdateDTO("meme", "ojingoo");

        // Act
        DiaryEntity updatedDiary = diaryServiceImpl.updateDiary(8L, diaryUpdateDTO);

        // Assert
        assertNotNull(updatedDiary);
        assertEquals(diaryUpdateDTO.getDiaryContent(), updatedDiary.getDiaryContent());
        assertEquals(diaryUpdateDTO.getFeelCategory(), updatedDiary.getFeelCategory());
    }
}
