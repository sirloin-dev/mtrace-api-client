package com.sirloin.mtraceapiclient.api.grade.confirm;

import com.sirloin.mtraceapiclient.api.fixtrue.MockMtraceHttpClientImpl;
import com.sirloin.mtraceapiclient.api.grade.confirm.model.GradeConfirmInformation;
import com.sirloin.mtraceapiclient.internal.http.MtraceHttpClient;
import com.sirloin.mtraceapiclient.internal.http.exception.MtraceRequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;


class GradeConfirmImplTest {

    private GradeConfirm sut;

    private static final String TEST_ANIMAL_NO = "002147460101";
    private static final String TEST_SERVICE_KEY = "";

    @DisplayName("소 개체정보의 등급판정 확인서를 조회합니다.")
    @Test
    void gradeConfirm() throws Exception {
        //given
        sut = new GradeConfirmImpl(
                new MockMtraceHttpClientImpl(
                        GradeConfirmImplTest.class.getResourceAsStream("/MockGradeConfirmResponse.xml")
                ),
                TEST_SERVICE_KEY
        );

        //when
        GradeConfirmInformation result = sut.gradeConfirm(TEST_ANIMAL_NO);

        //then
        Instant issueDate = LocalDate.of(2022, 5, 24).atStartOfDay().toInstant(ZoneOffset.UTC);
        assertAll(
                () -> assertThat(result.getAnimalNo(), is(TEST_ANIMAL_NO)),
                () -> assertThat(result.getJudgeKindNm(), is("소")),
                () -> assertThat(result.getIssueNo(), is("0323-05240157")),
                () -> assertThat(result.getIssueDate(), is(issueDate))
        );
    }

    @DisplayName("소 개체정보의 등급판정 결과를 조회에 실패합니다.")
    @Test
    void gradeConfirm_fail() throws Exception {
        //given
        sut = new GradeConfirmImpl(
                new MockMtraceHttpClientImpl(
                        GradeConfirmImplTest.class.getResourceAsStream("/MockErrorResponse.xml")
                ),
                TEST_SERVICE_KEY
        );

        //when //then
        MtraceRequestException mtraceRequestException =
                assertThrows(MtraceRequestException.class, () -> sut.gradeConfirm(TEST_ANIMAL_NO));
        assertAll(
                ()-> assertThat(mtraceRequestException.getMtraceErrorCode(),is("99")),
                ()-> assertThat(mtraceRequestException.getMessage(),is("INVALID REQUEST PARAMETER ERROR."))
        );
    }

}