package com.sirloin.mtraceapiclient.api.grade.confirm;

import com.sirloin.mtraceapiclient.api.fixtrue.MockMtraceHttpClientImpl;
import com.sirloin.mtraceapiclient.api.grade.confirm.model.GradeConfirmInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;


class GradeConfirmImplTest {

    private GradeConfirm sut;

    private static final String TEST_ANIMAL_NO = "002147460101";
    private static final String TEST_SERVICE_KEY = "";

    @DisplayName("소 개체정보의 등급판정 결과를 조회합니다.")
    @Test
    void gradeConfirm() throws Exception {
        //given
        sut = new GradeConfirmImpl(
                new MockMtraceHttpClientImpl(
                        GradeConfirmImplTest.class.getResourceAsStream("/MockGradeConfirmResponse.xml")
                )
        );

        //when
        GradeConfirmInformation result = sut.gradeConfirm(TEST_ANIMAL_NO, TEST_SERVICE_KEY);

        //then
        Instant issueDate = LocalDate.of(2022,5,24).atStartOfDay().toInstant(ZoneOffset.UTC);
        assertAll(
                () -> assertThat(result.animalNo(),is(TEST_ANIMAL_NO)),
                () -> assertThat(result.judgeKindNm(),is("소")),
                () -> assertThat(result.issueNo(),is("0323-05240157")),
                () -> assertThat(result.issueDate(),is(issueDate))
        );
    }
}