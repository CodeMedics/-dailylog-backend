package com.ohgiraffers.dailylogbackend.diary;

import com.ohgiraffers.dailylogbackend.diary.command.application.dto.DiaryWriteDTO;
import com.ohgiraffers.dailylogbackend.diary.command.application.service.DiaryServiceImpl;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.diary.command.infra.repository.DiaryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DiaryWriteMockTest {

    @Mock
    private DiaryRepository diaryRepository;

    @InjectMocks
    private DiaryServiceImpl diaryServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("diary insert mock test")
    public void testDiaryWrite() {
        // Arrange
        DiaryWriteDTO diaryWriteDTO = DiaryWriteDTO.builder()
                .diaryContent("good")
                .feelCategory("bad")
                .build();

        DiaryEntity mockedDiaryEntity = DiaryEntity.builder()
                .diaryContent(diaryWriteDTO.getDiaryContent())
                .feelCategory(diaryWriteDTO.getFeelCategory())
                .build();

        when(diaryRepository.save(any(DiaryEntity.class))).thenReturn(mockedDiaryEntity);

        // Act
        DiaryEntity createdDiary = diaryServiceImpl.writeDiary(diaryWriteDTO);

        // Assert
        assertEquals("good", createdDiary.getDiaryContent());
        assertEquals("bad", createdDiary.getFeelCategory());
    }
}
