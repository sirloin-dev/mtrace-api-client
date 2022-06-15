package com.sirloin.mtraceapiclient.api.trace.model;


import javax.annotation.Nonnull;

/**
 * 포장처리 정보.
 *
 * @param processPlaceAddr 포장처리업소 주소
 * @param processPlaceNm 포장처리업소명
 * @param infoType 조회정보
 * @param traceNoType 소/돼지/묶음 구분
 */
public record ProcessPlaceInformation(
        @Nonnull String processPlaceAddr,
        @Nonnull String processPlaceNm,
        int infoType,
        @Nonnull String traceNoType
) {

}
