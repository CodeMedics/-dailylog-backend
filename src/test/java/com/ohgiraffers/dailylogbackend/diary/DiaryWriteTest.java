package com.ohgiraffers.dailylogbackend.diary;

import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.diary.command.infra.repository.DiaryRepository;
import com.ohgiraffers.dailylogbackend.diary.command.infra.service.DiaryService;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DiaryWriteTest {

    @Mock
    private DiaryRepository diaryRepository;

    @InjectMocks
    private DiaryService diaryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testWriteDiary() {
        // Arrange
//        MemberEntity memberEntity = new MemberEntity();
        DiaryEntity diaryEntity = new DiaryEntity();

        diaryEntity.setDiaryContent("haha");
//        diaryEntity.setMember(memberEntity);
        diaryEntity.setFeelCategory("hahs");

        // Act
        DiaryEntity createdDiary = diaryService.writeDiary(diaryEntity);

        // Assert
        assertNotNull(createdDiary);
        System.out.println(createdDiary.getDiaryNo());
        assertEquals(diaryEntity.getDiaryContent(), createdDiary.getDiaryContent());
        assertEquals(diaryEntity.getFeelCategory(), createdDiary.getFeelCategory());
        assertEquals(DeleteEnum.PRESENT, createdDiary.getIfDelete());
        assertEquals(0, createdDiary.getLikeCount());


    }
}
