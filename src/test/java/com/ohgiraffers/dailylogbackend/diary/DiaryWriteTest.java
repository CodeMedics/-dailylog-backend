package com.ohgiraffers.dailylogbackend.diary;

import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.diary.command.application.service.DiaryServiceImpl;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.diary.command.infra.repository.DiaryRepository;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class DiaryWriteTest {

    @Mock
    private DiaryRepository diaryRepository;

    @InjectMocks
    private DiaryServiceImpl diaryServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testWriteDiary() {
        // Arrange
//        MemberEntity memberEntity = new MemberEntity();
        DiaryEntity diaryEntity = DiaryEntity.builder()
                .diaryContent("lol")
                .feelCategory("good")
                .build();


        when(diaryRepository.save(any(DiaryEntity.class))).thenReturn(diaryEntity);

        // Act
//        DiaryEntity createdDiary = diaryServiceImpl.writeDiary(diaryEntity);


        // Assert
//        assertNotNull(createdDiary);
    }
}
