package com.ohgiraffers.dailylogbackend.diary;

import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.diary.command.application.dto.DiaryWriteDTO;
import com.ohgiraffers.dailylogbackend.diary.command.application.service.DiaryServiceImpl;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.diary.command.infra.repository.DiaryRepository;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
//@DataJpaTest // 데이터 롤백됨
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DiaryWriteTest {

    @Autowired
    private DiaryServiceImpl diaryServiceImpl;

    @Test
    @DisplayName("diary insert test")
    public void testWriteDiary() {
        // Arrange
        DiaryWriteDTO diaryWriteDTO = DiaryWriteDTO.builder()
                .diaryContent("lol")
                .feelCategory("good")
                .build();

        // Act
        DiaryEntity diaryEntity = diaryServiceImpl.writeDiary(diaryWriteDTO);

        // Assert
        assertNotNull(diaryEntity);
        assertEquals(diaryWriteDTO.getDiaryContent(), diaryEntity.getDiaryContent());
        assertEquals(diaryWriteDTO.getFeelCategory(), diaryEntity.getFeelCategory());
    }
}
