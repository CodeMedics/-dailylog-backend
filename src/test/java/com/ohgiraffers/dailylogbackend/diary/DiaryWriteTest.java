package com.ohgiraffers.dailylogbackend.diary;

import com.ohgiraffers.dailylogbackend.diary.command.application.dto.DiaryWriteDTO;
import com.ohgiraffers.dailylogbackend.diary.command.application.service.DiaryServiceImpl;
import com.ohgiraffers.dailylogbackend.diary.command.domain.aggregate.entity.DiaryEntity;
import com.ohgiraffers.dailylogbackend.diary.command.infra.repository.DiaryRepository;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.entity.MemberEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
//@DataJpaTest // 데이터 롤백됨
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DiaryWriteTest {

    @Autowired
    private DiaryServiceImpl diaryServiceImpl;

//    @Autowired
//    private DiaryRepository diaryRepository;

    @Test
    @DisplayName("diary insert test")
    public void testWriteDiary() {
        // Arrange

        MemberEntity memberEntity = MemberEntity.builder()
                .memberNo(1L)
                .build();

        DiaryWriteDTO diaryWriteDTO = new DiaryWriteDTO(memberEntity, "lol", "good");

//        DiaryEntity de = new DiaryEntity(diaryWriteDTO.getMemberEntity(),
//                diaryWriteDTO.getDiaryContent(),
//                diaryWriteDTO.getFeelCategory());

        // Act
        DiaryEntity diaryEntity = diaryServiceImpl.writeDiary(diaryWriteDTO);
//
////        DiaryEntity diaryEntity = diaryRepository.save(de);
//
//        // Assert
        assertNotNull(diaryEntity);
        assertEquals(diaryWriteDTO.getDiaryContent(), diaryEntity.getDiaryContent());
        assertEquals(diaryWriteDTO.getFeelCategory(), diaryEntity.getFeelCategory());
    }
}
