package com.ohgiraffers.dailylogbackend.diary.update;

import com.ohgiraffers.dailylogbackend.diary.command.application.dto.DiaryUpdateDTO;
import com.ohgiraffers.dailylogbackend.diary.command.application.service.DiaryServiceImpl;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.diary.command.infra.repository.DiaryRepository;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class DiaryUpdateMockTest {

    @Mock
    private DiaryRepository diaryRepository;

    @InjectMocks
    private DiaryServiceImpl diaryServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("diary update mock test")
    public void diaryUpdateMockTest() {
        // Arrange
        MemberEntity memberEntity = MemberEntity.builder()
                .memberNo(1L)
                .build();

        DiaryUpdateDTO diaryUpdateDTO = new DiaryUpdateDTO("omg", "amazing");

        DiaryEntity mockedDiaryEntity = new DiaryEntity(memberEntity,
                diaryUpdateDTO.getDiaryContent(),
                diaryUpdateDTO.getFeelCategory());

        Long diaryNo = 7L;


        when(diaryRepository.getReferenceById(diaryNo)).thenReturn(mockedDiaryEntity);
        when(diaryRepository.save(any(DiaryEntity.class))).thenReturn(mockedDiaryEntity);

        // Act
        DiaryEntity createdDiary = diaryServiceImpl.updateDiary(diaryNo, diaryUpdateDTO);

        // Assert
        assertEquals(diaryUpdateDTO.getDiaryContent(), createdDiary.getDiaryContent());
        assertEquals(diaryUpdateDTO.getFeelCategory(), createdDiary.getFeelCategory());
    }
}
