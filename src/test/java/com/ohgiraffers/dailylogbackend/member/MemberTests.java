package com.ohgiraffers.dailylogbackend.member;

import com.ohgiraffers.dailylogbackend.common.enumType.DeleteEnum;
import com.ohgiraffers.dailylogbackend.member.command.application.dto.CreateMemberDTO;
import com.ohgiraffers.dailylogbackend.member.command.application.service.CreateMemberService;
import com.ohgiraffers.dailylogbackend.member.command.domain.aggregate.EnumType.SocialEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Stream;

@SpringBootTest
@Transactional
public class MemberTests {

    @Autowired
    private CreateMemberService createMemberService;

//    private static Stream<Arguments> getMember() {
//        return Stream.of(
//                Arguments.of(
//                        new CreateMemberDTO(
//                                "whvudgns123",
//                                "너구리",
//                                "잘생긴 사진.jpg",
//                                "123123",
//                                "123123",
//                                SocialEnum.KAKAO,
//                                DeleteEnum.PRESENT
//
//                        )
//                ),
//                Arguments.of(
//                        new CreateMemberDTO(
//                                "whvudgns1231",
//                                "너구리",
//                                "잘생긴 사진.jpg",
//                                "123123",
//                                "123123",
//                                SocialEnum.KAKAO,
//                                DeleteEnum.PRESENT
//                        )
//                )
//
//        );
//    }
//
//    @ParameterizedTest
//    @MethodSource("getMember")
//    void create(CreateMemberDTO createMemberDTO) {
//        Assertions.assertDoesNotThrow(
//                () -> createMemberService.create(createMemberDTO)
//        );
//    }
}
