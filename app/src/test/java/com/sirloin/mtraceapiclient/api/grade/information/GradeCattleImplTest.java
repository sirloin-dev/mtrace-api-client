package com.sirloin.mtraceapiclient.api.grade.information;

import com.sirloin.mtraceapiclient.api.fixtrue.MockMtraceHttpClientImpl;
import com.sirloin.mtraceapiclient.api.grade.information.model.CattleGradeInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class GradeCattleImplTest {

    private GradeCattleImpl sut;

    private static final String TEST_ISSUE_DATE_STR = "2022-05-24";
    private static final String TEST_ISSUE_NO = "0323-05240157";
    private static final String TEST_SERVICE_KEY = "";

    @DisplayName("소의 등급판정결과 정보를 가져옵니다.")
    @Test
    void gradeConfirm() throws Exception {
        //given
        sut = new GradeCattleImpl(
                new MockMtraceHttpClientImpl(
                        GradeCattleImplTest.class.getResourceAsStream("/MockGradeInfoResponse.xml")
                )
        );

        //when
        CattleGradeInformation result = sut.grade(TEST_ISSUE_NO, TEST_ISSUE_DATE_STR, TEST_SERVICE_KEY);
        //then
        Instant issueDate = LocalDate.of(2022, 5, 24).atStartOfDay().toInstant(ZoneOffset.UTC);
        assertAll(
                () -> assertThat(result.getIssueNo(), is("0323-05240157")),
                () -> assertThat(result.getIssueDate(), is(issueDate)),
                () -> assertThat(result.getWgrade(), is("A")),
                () -> assertThat(result.getJudgeBreedNm(), is("한우")),
                () -> assertThat(result.getFatsak(), is("3")),
                () -> assertThat(result.getYuksak(), is("5"))
        );
    }

}
