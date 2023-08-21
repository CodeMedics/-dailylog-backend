//package com.ohgiraffers.dailylogbackend.diary.write;
//
//import com.ohgiraffers.dailylogbackend.diary.command.application.dto.DiaryWriteDTO;
//import com.ohgiraffers.dailylogbackend.diary.command.application.service.DiaryService;
//import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
//import com.ohgiraffers.dailylogbackend.diary.command.infra.repository.DiaryRepository;
//import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//public class DiaryWriteMockTest {
//
//    @Mock
//    private DiaryRepository diaryRepository;
//
//    @InjectMocks
//    private DiaryService diaryService;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    @DisplayName("diary insert mock test")
//    public void testDiaryWrite() {
//        // Arrange
//        MemberEntity memberEntity = MemberEntity.builder()
//                .memberNo(1L)
//                .build();
//
//        DiaryWriteDTO diaryWriteDTO = new DiaryWriteDTO(memberEntity,
//                "lol",
//                "good");
//
//        DiaryEntity mockedDiaryEntity = new DiaryEntity(diaryWriteDTO.getMemberEntity(),
//                diaryWriteDTO.getDiaryContent(),
//                diaryWriteDTO.getFeelCategory());
//
//        when(diaryRepository.save(any(DiaryEntity.class))).thenReturn(mockedDiaryEntity);
//
//        // Act
//        DiaryEntity createdDiary = diaryService.writeDiary(diaryWriteDTO);
//
//        // Assert
//        assertNotNull(createdDiary);
//        assertEquals(memberEntity.getMemberNo(), createdDiary.getMemberEntity().getMemberNo());
//        assertEquals(diaryWriteDTO.getDiaryContent(), createdDiary.getDiaryContent());
//        assertEquals(diaryWriteDTO.getFeelCategory(), createdDiary.getFeelCategory());
//    }
//}
