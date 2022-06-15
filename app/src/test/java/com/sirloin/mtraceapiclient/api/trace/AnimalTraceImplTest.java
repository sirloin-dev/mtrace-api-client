package com.sirloin.mtraceapiclient.api.trace;

import com.sirloin.mtraceapiclient.internal.http.exception.MtraceRequestException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import com.sirloin.mtraceapiclient.api.fixtrue.MockMtraceHttpClientImpl;
import com.sirloin.mtraceapiclient.api.trace.model.TraceResult;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.*;

class AnimalTraceImplTest {
    private static final String TEST_TRACE_NO = "002147460101";
    private static final String TEST_SERVICE_KEY = "";

    private AnimalTrace sut;

    @DisplayName("통합이력정보를 조회합니다.")
    @Test
    void callTraceNoSearch() throws Exception {
        //given
        sut = new AnimalTraceImpl(
                new MockMtraceHttpClientImpl(
                        AnimalTraceImplTest.class.getResourceAsStream("/MockAnimalTraceResponse.xml")
                ),
                TEST_SERVICE_KEY
        );

        //when
        TraceResult result = sut.traceNoSearch(TEST_TRACE_NO);

        //then
        assertAll(
                () -> assertThat(result.getAnimalInformation().getCattleNo(), is("410002147460101")),
                () -> assertThat(result.getAnimalInformation().getLsTypeNm(), is("한우")),
                () -> assertThat(result.getFarmInformation().size(), is(5)),
                () -> assertThat(result.getButcheryInformation().getGradeNm(), is("2")),
                () -> assertThat(result.getProcessPlaceInformation().getProcessPlaceAddr(), is("경기도 안산시 단원구 화정동 꽃우물길")),
                () -> assertThat(result.getInjectionInformation().getInjectiondayCnt(), is("접종 후 38일 경과")),
                () -> assertThat(result.getInspectInformation().getInspectYn(), is("음성"))
        );
    }

    @DisplayName("통합이력정보를 조회합니다. 1번 옵션(개체정보)의 정보만 가져옵니다. ")
    @Test
    void callTraceNoSearch_optionNo() throws Exception {
        //given
        sut = new AnimalTraceImpl(
                new MockMtraceHttpClientImpl(
                        AnimalTraceImplTest.class.getResourceAsStream("/MockAnimalTraceResponse2.xml")
                ),
                TEST_SERVICE_KEY
        );
        //when
        TraceResult result = sut.traceNoSearch(TEST_TRACE_NO, 1);

        //then
        assertAll(
                () -> assertThat(result.getAnimalInformation().getCattleNo(), is("410002147460101")),
                () -> assertThat(result.getAnimalInformation().getLsTypeNm(), is("한우")),
                () -> assertThat(result.getAnimalInformation().getFarmNo(), is("292956")),
                () -> assertThat(result.getFarmInformation().size(), is(0)),
                () -> assertThat(result.getButcheryInformation(), is(nullValue()))
        );
    }

    @DisplayName("통합이력정보를 조회합니다. 사업장번호로 검색후 3번 옵션(도축장)의 정보를 가져옵니다.")
    @Test
    void callTraceNoSearch_optionNo_and_corpNo() throws Exception {
        //given
        sut = new AnimalTraceImpl(
                new MockMtraceHttpClientImpl(
                        AnimalTraceImplTest.class.getResourceAsStream("/MockAnimalTraceResponse3.xml")
                ),
                TEST_SERVICE_KEY
        );

        //when
        TraceResult result = sut.traceNoSearch(TEST_TRACE_NO, 3, "1178522046");

        //then
        assertAll(
                () -> assertThat(result.getAnimalInformation(), is(nullValue())),
                () -> assertThat(result.getButcheryInformation().getGradeNm(), is("2"))
        );

    }

    @DisplayName("통합이력정보 조회에 실패합니다.")
    @Test
    void callTraceNoSearch_fail() throws Exception {
        //given
        sut = new AnimalTraceImpl(
                new MockMtraceHttpClientImpl(
                        AnimalTraceImplTest.class.getResourceAsStream("/MockErrorResponse.xml")
                ),
                TEST_SERVICE_KEY
        );


        //when //then
        MtraceRequestException mtraceRequestException =
                assertThrows(MtraceRequestException.class, () -> sut.traceNoSearch(TEST_TRACE_NO));
        assertAll(
                () -> assertThat(mtraceRequestException.getMtraceErrorCode(), is("99")),
                () -> assertThat(mtraceRequestException.getMessage(), is("INVALID REQUEST PARAMETER ERROR."))
        );
    }
}