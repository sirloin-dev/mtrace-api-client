package com.sirloin.mtraceapiclient.api.trace.model;

import javax.annotation.Nonnull;
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
        @Nonnull String butcheryPlaceAddr,
        @Nonnull String butcheryPlaceNm,
        @Nonnull Instant butcheryYmd,
        @Nonnull String gradeNm,
        int infoType,
        @Nonnull String inspectPassYn,
        @Nonnull String traceNoType
) {

}
