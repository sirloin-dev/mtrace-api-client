package com.sirloin.mtraceapiclient.api.grade.confirm.model;

import java.time.ZonedDateTime;
import java.util.Objects;

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
    private final ZonedDateTime abattDate;
    /**
     * 판정일자.
     */
    private final ZonedDateTime judgeDate;
    /**
     * 확인서발급일자.
     */
    private final ZonedDateTime issueDate;
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
            final ZonedDateTime abattDate,
            final ZonedDateTime judgeDate,
            final ZonedDateTime issueDate,
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
    public ZonedDateTime getAbattDate() {
        return abattDate;
    }

    /**
     * @return 판정일자.
     */
    public ZonedDateTime getJudgeDate() {
        return judgeDate;
    }

    /**
     * @return 확인서발급일자.
     */
    public ZonedDateTime getIssueDate() {
        return issueDate;
    }

    /**
     * @return 확인서발급번호.
     */
    public String getIssueNo() {
        return issueNo;
    }

    /**
     * 기본 eq and hashcode.
     *
     * @param o
     * @return boolean
     */
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GradeConfirmInformation that = (GradeConfirmInformation) o;
        return Objects.equals(animalNo, that.animalNo)
                && Objects.equals(judgeKindCd, that.judgeKindCd)
                && Objects.equals(judgeKindNm, that.judgeKindNm)
                && Objects.equals(abattCode, that.abattCode)
                && Objects.equals(abattNm, that.abattNm)
                && Objects.equals(abattDate, that.abattDate)
                && Objects.equals(judgeDate, that.judgeDate)
                && Objects.equals(issueDate, that.issueDate)
                && Objects.equals(issueNo, that.issueNo);
    }

    /**
     * 기본 해쉬코드.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(
                animalNo, judgeKindCd, judgeKindNm, abattCode, abattNm, abattDate, judgeDate, issueDate, issueNo
        );
    }
}
