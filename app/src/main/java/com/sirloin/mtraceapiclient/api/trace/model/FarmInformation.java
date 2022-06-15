package com.sirloin.mtraceapiclient.api.trace.model;

import javax.annotation.Nonnull;
import java.time.Instant;

/**
 * 출생 등 신고정보.
 *
 * @param farmAddr 농장주소
 * @param farmNo 농장번호
 * @param farmerNm 소유주
 * @param infoType 조회정보
 * @param regType 전산등록
 * @param regYmd 신고년월일
 * @param traceNoType 소/돼지/묶음 구분
 */
public record FarmInformation(
        @Nonnull String farmAddr,
        @Nonnull String farmNo,
        @Nonnull String farmerNm,
        int infoType,
        @Nonnull String regType,
        @Nonnull Instant regYmd,
        @Nonnull String traceNoType
) {


}
