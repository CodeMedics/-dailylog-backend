package com.ohgiraffers.dailylogbackend.diary;

import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.diary.command.application.dto.DiaryUpdateDTO;
import com.ohgiraffers.dailylogbackend.diary.command.application.dto.DiaryWriteDTO;
import com.ohgiraffers.dailylogbackend.diary.command.application.service.DiaryService;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.feed.query.application.service.GetFeedService;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DiaryTest {

    @Autowired
    private DiaryService diaryService;

    @Autowired
    private GetFeedService getFeedService;

    @Autowired
    private InsertFakeUser insertFakeUser;

    public MemberEntity setUp() {
        return insertFakeUser.insertFakeUser();
    }

//    private MemberEntity userSet(Long MemberNo) {
//
//    }

    @Test
    @DisplayName("diary insert test")
    public void testWriteDiary() {
        // Arrange

        MemberEntity fakeUser = setUp();

        MemberEntity memberEntity = MemberEntity.builder()
                .memberNo(fakeUser.getMemberNo())
                .build();

        DiaryWriteDTO diaryWriteDTO = new DiaryWriteDTO(memberEntity, "create", "create");

        // Act
        DiaryEntity diaryEntity = diaryService.writeDiary(diaryWriteDTO);

        // Assert
        assertNotNull(diaryEntity);
        assertEquals(diaryWriteDTO.getDiaryContent(), diaryEntity.getDiaryContent());
        assertEquals(diaryWriteDTO.getFeelCategory(), diaryEntity.getFeelCategory());

    }

    @Test
    @DisplayName("diary read test")
    public void diaryReadTest() {
        // Arrange

        // Act
        List<DiaryEntity> diaryFeedList = getFeedService.getFeedList();

        // Assert
//        assertNotNull();

    }

    @Test
    @DisplayName("diary update test")
    public void diaryUpdateTest() {
        // Arrange

        DiaryUpdateDTO diaryUpdateDTO = new DiaryUpdateDTO("update", "update");

        // Act
        DiaryEntity updatedDiary = diaryService.updateDiary(1L, diaryUpdateDTO);

        // Assert
        assertNotNull(updatedDiary);
        assertEquals(diaryUpdateDTO.getDiaryContent(), updatedDiary.getDiaryContent());
        assertEquals(diaryUpdateDTO.getFeelCategory(), updatedDiary.getFeelCategory());
    }

    @Test
    @DisplayName("diary delete test")
    public void diaryDeleteTest() {
        // Arrange

        // Act
        DiaryEntity deletedDiary = diaryService.deleteDiary(1L);

        // Assert
        assertEquals(deletedDiary.getIfDelete(), DeleteEnum.DELETED);

    }
}
