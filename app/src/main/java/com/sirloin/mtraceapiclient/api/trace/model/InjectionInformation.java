package com.sirloin.mtraceapiclient.api.trace.model;

import javax.annotation.Nonnull;
import java.time.Instant;

/**
 * 백신접종 정보.
 *
 * @param injectionYmd    구제역 예방접종최종일자
 * @param injectiondayCnt 구제역 백신접종경과일
 * @param vaccineorder    구제역 백신접종 차수
 * @param infoType        조회정보
 * @param traceNoType     소/돼지/묶음 구분
 */
public record InjectionInformation(
        @Nonnull Instant injectionYmd,
        @Nonnull String injectiondayCnt,
        @Nonnull String vaccineorder,
        int infoType,
        @Nonnull String traceNoType
) {

}
