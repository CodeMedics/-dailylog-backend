//package com.ohgiraffers.dailylogbackend.diary.delete;
//
//import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
//import com.ohgiraffers.dailylogbackend.diary.command.application.service.DiaryService;
//import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest
//public class DiaryDeleteTest {
//
//    @Autowired
//    private DiaryService diaryService;
//
//    @Test
//    @DisplayName("diary delete test")
//    public void diaryDeleteTest() {
//        // Arrange
//
//        // Act
//        DiaryEntity deletedDiary = diaryService.deleteDiary(1L);
//
//        // Assert
//        assertEquals(deletedDiary.getIfDelete(), DeleteEnum.DELETED);
//    }
//}
