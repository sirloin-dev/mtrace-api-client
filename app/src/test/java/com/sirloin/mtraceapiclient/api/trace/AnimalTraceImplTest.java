package com.sirloin.mtraceapiclient.api.trace;

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
                )
        );

        //when
        TraceResult result = sut.traceNoSearch(TEST_TRACE_NO, TEST_SERVICE_KEY);

        //then
        assertAll(
                () -> assertThat(result.animalInformation().cattleNo(), is("410002147460101")),
                () -> assertThat(result.animalInformation().lsTypeNm(), is("한우")),
                () -> assertThat(result.farmInformation().size(), is(5)),
                () -> assertThat(result.butcheryInformation().gradeNm(), is("2")),
                () -> assertThat(result.processPlaceInformation().processPlaceAddr(), is("경기도 안산시 단원구 화정동 꽃우물길")),
                () -> assertThat(result.injectionInformation().injectiondayCnt(), is("접종 후 38일 경과")),
                () -> assertThat(result.inspectInformation().inspectYn(), is("음성"))
        );
    }

    @DisplayName("통합이력정보를 조회합니다. 1번 옵션(개체정보)의 정보만 가져옵니다. ")
    @Test
    void callTraceNoSearch_optionNo() throws Exception {
        //given
        sut = new AnimalTraceImpl(
                new MockMtraceHttpClientImpl(
                        AnimalTraceImplTest.class.getResourceAsStream("/MockAnimalTraceResponse2.xml")
                )
        );
        //when
        TraceResult result = sut.traceNoSearch(TEST_TRACE_NO, TEST_SERVICE_KEY, 1);

        //then
        assertAll(
                () -> assertThat(result.animalInformation().cattleNo(), is("410002147460101")),
                () -> assertThat(result.animalInformation().lsTypeNm(), is("한우")),
                () -> assertThat(result.animalInformation().farmNo(), is("292956")),
                () -> assertThat(result.farmInformation().size(), is(0)),
                () -> assertThat(result.butcheryInformation(), is(nullValue()))
        );
    }

    @DisplayName("통합이력정보를 조회합니다. 사업장번호로 검색후 3번 옵션(도축장)의 정보를 가져옵니다.")
    @Test
    void callTraceNoSearch_optionNo_and_corpNo() throws Exception {
        //given
        sut = new AnimalTraceImpl(
                new MockMtraceHttpClientImpl(
                        AnimalTraceImplTest.class.getResourceAsStream("/MockAnimalTraceResponse3.xml")
                )
        );

        //when
        TraceResult result = sut.traceNoSearch(TEST_TRACE_NO, TEST_SERVICE_KEY, 3, "1178522046");

        //then
        assertAll(
                () -> assertThat(result.animalInformation(), is(nullValue())),
                () -> assertThat(result.butcheryInformation().gradeNm(), is("2"))
        );

    }
}