package com.ohgiraffers.dailylogbackend.diary;

import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.diary.command.application.dto.DiaryUpdateDTO;
import com.ohgiraffers.dailylogbackend.diary.command.application.dto.DiaryWriteDTO;
import com.ohgiraffers.dailylogbackend.diary.command.application.service.DiaryService;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.diary.query.application.service.GetDiaryService;
import com.ohgiraffers.dailylogbackend.feed.command.application.service.FeedService;
import com.ohgiraffers.dailylogbackend.feed.command.domain.aggregate.entity.FeedEntity;
import com.ohgiraffers.dailylogbackend.feed.query.application.service.GetFeedService;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DiaryTest {

    @Autowired
    private DiaryService diaryService;

    @Autowired
    private GetDiaryService getDiaryService;

    @Autowired
    private InsertFakeUser insertFakeUser;

    @Autowired
    private FeedService feedService;

    @Autowired
    GetFeedService getFeedService;

    private static MemberEntity staticMemberEntity;
    private static DiaryEntity staticDiaryEntity;

    public MemberEntity setUp() {
        return insertFakeUser.insertFakeUser();
    }

    public void tearDown() {
        insertFakeUser.deleteFakeData(staticMemberEntity);
    }

    @Test
    @DisplayName("diary insert test")
    @Order(1)
    public void testWriteDiary() {
        // Arrange

        staticMemberEntity = setUp();

        MemberEntity memberEntity = MemberEntity.builder()
                .memberNo(staticMemberEntity.getMemberNo())
                .build();

        DiaryWriteDTO diaryWriteDTO = new DiaryWriteDTO(memberEntity, "create", "create", LocalDate.now());

        // Act
        staticDiaryEntity = diaryService.writeDiary(diaryWriteDTO);

        // Assert
        assertNotNull(staticDiaryEntity);
        assertEquals(diaryWriteDTO.getDiaryContent(), staticDiaryEntity.getDiaryContent());
        assertEquals(diaryWriteDTO.getFeelCategory(), staticDiaryEntity.getFeelCategory());

    }

//    @Test
//    @DisplayName("my diary read test")
//    @Order(2)
//    public void diaryReadTest() {
//        // Arrange
//        LocalDate today = LocalDate.now();
//
//        // Act
//        DiaryEntity myDiary = getDiaryService.getMyDiary(staticMemberEntity, today);
//
//        // Assert
//        assertNotNull(myDiary);
//        assertEquals(staticDiaryEntity.getDiaryContent(), myDiary.getDiaryContent());
//        assertEquals(staticDiaryEntity.getFeelCategory(), myDiary.getFeelCategory());
//        assertEquals(today, myDiary.getDiaryDate());
//    }
//
//    @Test
//    @DisplayName("diary feed write test")
//    @Order(3)
//    public void diaryFeedWriteTest() {
//        // Arrange
//
//        // Act
//        List<FeedEntity> feedInsertedList =  feedService.createFeed();
//
//        // Assert
//        assertNotNull(feedInsertedList);
//    }
//
//    @Test
//    @DisplayName("diary feed read test")
//    @Order(4)
//    public void diaryFeedReadTest() {
//        // Arrange
//
//        // Act
//        List<FeedEntity> feedList = getFeedService.getFeedList();
//        // Assert
//        assertNotNull(feedList);
//    }

    @Test
    @DisplayName("diary update test")
    @Order(5)
    public void diaryUpdateTest() {
        // Arrange

        DiaryUpdateDTO diaryUpdateDTO = new DiaryUpdateDTO("update", "update");

        // Act

        DiaryEntity updatedDiary = diaryService.updateDiary(staticDiaryEntity.getDiaryNo(), diaryUpdateDTO);
        // Assert
        assertNotNull(updatedDiary);
        assertEquals(diaryUpdateDTO.getDiaryContent(), updatedDiary.getDiaryContent());
        assertEquals(diaryUpdateDTO.getFeelCategory(), updatedDiary.getFeelCategory());
    }

    @Test
    @DisplayName("diary delete test")
    @Order(6)
    public void diaryDeleteTest() {
        // Arrange

        // Act
        DiaryEntity deletedDiary = diaryService.deleteDiary(staticDiaryEntity.getDiaryNo());

        // Assert
        assertEquals(deletedDiary.getIfDelete(), DeleteEnum.DELETED);

        tearDown();

    }
}
