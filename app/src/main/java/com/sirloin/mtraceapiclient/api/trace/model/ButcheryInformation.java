package com.sirloin.mtraceapiclient.api.trace.model;

import javax.validation.constraints.NotNull;
import java.time.Instant;

/**
 * 도축장 정보.
 *
 * @param butcheryPlaceAddr 도축장 주소
 * @param butcheryPlaceNm   도축장명
 * @param butcheryYmd       도축일자
 * @param gradeNm           등급명
 * @param infoType          조회정보
 * @param inspectPassYn     위생검사 결과
 * @param traceNoType       소/돼지/묶음 구분
 */
public record ButcheryInformation(
        @NotNull String butcheryPlaceAddr,
        @NotNull String butcheryPlaceNm,
        @NotNull Instant butcheryYmd,
        @NotNull String gradeNm,
        int infoType,
        @NotNull String inspectPassYn,
        @NotNull String traceNoType
) {

}
