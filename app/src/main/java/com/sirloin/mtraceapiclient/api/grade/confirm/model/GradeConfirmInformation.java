package com.sirloin.mtraceapiclient.api.grade.confirm.model;

import java.time.Instant;

public record GradeConfirmInformation(
        /* 이력번호 */
        String animalNo,
        /* 축종 코드 */
        String judgeKindCd,
        /* 가축명 */
        String judgeKindNm,
        /* 작업장코드 */
        String abattCode,
        /* 작업장명 */
        String abattNm,
        /* 도축일자 */
        Instant abattDate,
        /* 판정일자 */
        Instant judgeDate,
        /* 확인서발급일자 */
        Instant issueDate,
        /* 확인서발급번호 */
        String issueNo
) {
}
