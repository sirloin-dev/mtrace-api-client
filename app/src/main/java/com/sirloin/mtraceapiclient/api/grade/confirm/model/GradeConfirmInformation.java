package com.sirloin.mtraceapiclient.api.grade.confirm.model;

import java.time.Instant;

/**
 * 등급정보판정결과 확인서 정보.
 */
public class GradeConfirmInformation {
    /**
     * 이력번호.
     */
    private final String animalNo;
    /**
     * 축종 코드.
     */
    private final String judgeKindCd;
    /**
     * 가축명.
     */
    private final String judgeKindNm;
    /**
     * 작업장코드.
     */
    private final String abattCode;
    /**
     * 작업장명.
     */
    private final String abattNm;
    /**
     * 도축일자.
     */
    private final Instant abattDate;
    /**
     * 판정일자.
     */
    private final Instant judgeDate;
    /**
     * 확인서발급일자.
     */
    private final Instant issueDate;
    /**
     * 확인서발급번호.
     */
    private final String issueNo;

    /**
     * 등급정보판정결과 확인서 정보.
     *
     * @param animalNo
     * @param judgeKindCd
     * @param judgeKindNm
     * @param abattCode
     * @param abattNm
     * @param abattDate
     * @param judgeDate
     * @param issueDate
     * @param issueNo
     */
    public GradeConfirmInformation(
            final String animalNo,
            final String judgeKindCd,
            final String judgeKindNm,
            final String abattCode,
            final String abattNm,
            final Instant abattDate,
            final Instant judgeDate,
            final Instant issueDate,
            final String issueNo
    ) {
        this.animalNo = animalNo;
        this.judgeKindCd = judgeKindCd;
        this.judgeKindNm = judgeKindNm;
        this.abattCode = abattCode;
        this.abattNm = abattNm;
        this.abattDate = abattDate;
        this.judgeDate = judgeDate;
        this.issueDate = issueDate;
        this.issueNo = issueNo;
    }

    /**
     * @return 이력번호.
     */
    public String getAnimalNo() {
        return animalNo;
    }

    /**
     * @return 축종 코드.
     */
    public String getJudgeKindCd() {
        return judgeKindCd;
    }

    /**
     * @return 가축명.
     */
    public String getJudgeKindNm() {
        return judgeKindNm;
    }

    /**
     * @return 작업장코드.
     */
    public String getAbattCode() {
        return abattCode;
    }

    /**
     * @return 작업장명.
     */
    public String getAbattNm() {
        return abattNm;
    }

    /**
     * @return 도축일자.
     */
    public Instant getAbattDate() {
        return abattDate;
    }

    /**
     * @return 판정일자.
     */
    public Instant getJudgeDate() {
        return judgeDate;
    }

    /**
     * @return 확인서발급일자.
     */
    public Instant getIssueDate() {
        return issueDate;
    }

    /**
     * @return 확인서발급번호.
     */
    public String getIssueNo() {
        return issueNo;
    }
}
