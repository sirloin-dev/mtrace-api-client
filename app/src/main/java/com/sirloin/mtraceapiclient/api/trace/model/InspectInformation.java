package com.sirloin.mtraceapiclient.api.trace.model;

import javax.validation.constraints.NotNull;
import java.time.Instant;


/**
 * 가축질병 검사 정보.
 *
 * @param inspectDt 브루셀라 검사최종일자
 * @param inspectYn 음성 or 양성
 * @param infoType 조회정보
 * @param traceNoType 소/돼지/묶음 구분
 */
public record InspectInformation(
        @NotNull Instant inspectDt,
        @NotNull String inspectYn,
        int infoType,
        @NotNull String traceNoType
) {

}
