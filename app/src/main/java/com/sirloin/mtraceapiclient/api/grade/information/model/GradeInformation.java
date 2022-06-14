package com.sirloin.mtraceapiclient.api.grade.information.model;

import java.time.Instant;

/**
 * 등급판정 정보입니다. 각 동물별 공통 정보를 취합한 모델입니다.
 */
public interface GradeInformation {

    /**
     * @return 발급일자
     */
    Instant getIssueDate();

    /**
     * @return 발급번호
     */
    String getIssueNo();

    /**
     * @return 품종코드
     */
    String getJudgeKindCd();

    /**
     * @return 평가사코드
     */
    String getRaterCode();

    /**
     * @return 평가사명
     */
    String getRaterNm();

    /**
     * @return 도축일자
     */
    Instant getAbattDate();

    /**
     * @return 도축장명
     */
    String getAbattNm();

    /**
     * @return 등급판정일자
     */
    Instant getJudgeDate();
    /**
     * @return 도축장코드
     */
    String getAbattCode();

    /**
     * @return 도축장주소
     */
    String getAbattAddr();

    /**
     * @return 도축장전화번호
     */
    String getAbattTelNo();

    /**
     * @return 신청인명
     */
    String getReqUserNm();

    /**
     * @return 신청업체사업자번호
     */
    String getReqRegNo();

    /**
     * @return 신청업체명
     */
    String getReqComNm();

    /**
     * @return 신청업체주소명
     */
    String getReqAddr();

    /**
     * @return 신청업체전화번호
     */
    String getReqTelNo();

    /**
     * @return 축종명
     */
    String getLiveStockNm();

    /**
     * @return 도축시작번호
     */
    String getAbattFno();

    /**
     * @return 도축종료번호
     */
    String getAbattTno();

    /**
     * @return 등급판정품종
     */
    String getJudgeBreedNm();

    /**
     * @return 등급판정성별
     */
    String getJudgeSexNm();

    /**
     * @return 도체중량
     */
    String getWeight();

    /**
     * @return 등급코드
     */
    String getGradeCd();

    /**
     * @return 등급명
     */
    String getGradeNm();

    /**
     * @return 경락가격
     */
    String getCostAmt();
}
