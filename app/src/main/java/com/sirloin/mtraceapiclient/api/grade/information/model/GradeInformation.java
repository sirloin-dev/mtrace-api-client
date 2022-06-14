package com.sirloin.mtraceapiclient.api.grade.information.model;

import java.time.Instant;

/**
 * 등급판정 정보입니다. 각 동물별 공통 정보를 취합한 모델입니다.
 */
public abstract class GradeInformation {
    /**
     * 발급일자.
     */
    private final Instant issueDate;
    /**
     * 발급번호.
     */
    private final String issueNo;
    /**
     * 품종코드.
     */
    private final String judgeKindCd;
    /**
     * 평가사코드.
     */
    private final String raterCode;
    /**
     * 평가사명.
     */
    private final String raterNm;
    /**
     * 도축일자.
     */
    private final Instant abattDate;
    /**
     * 도축장명.
     */
    private final String abattNm;
    /**
     * 등급판정일자.
     */
    private final Instant judgeDate;
    /**
     * 도축장코드.
     */
    private final String abattCode;
    /**
     * 도축장주소.
     */
    private final String abattAddr;
    /**
     * 도축장전화번호.
     */
    private final String abattTelNo;
    /**
     * 신청인명.
     */
    private final String reqUserNm;
    /**
     * 신청업체사업자번호.
     */
    private final String reqRegNo;
    /**
     * 신청업체명.
     */
    private final String reqComNm;
    /**
     * 신청업체주소명.
     */
    private final String reqAddr;
    /**
     * 신청업체전화번호.
     */
    private final String reqTelNo;
    /**
     * 축종명.
     */
    private final String liveStockNm;
    /**
     * 도축시작번호.
     */
    private final String abattFno;
    /**
     * 도축종료번호.
     */
    private final String abattTno;
    /**
     * 등급판정품종.
     */
    private final String judgeBreedNm;
    /**
     * 등급판정성별.
     */
    private final String judgeSexNm;
    /**
     * 도체중량.
     */
    private final String weight;
    /**
     * 등급코드.
     */
    private final String gradeCd;
    /**
     * 등급명.
     */
    private final String gradeNm;
    /**
     * 경락가격.
     */
    private final String costAmt;

    @SuppressWarnings("checkstyle:parameternumber") // api의 parameter의 갯수가 많아 해당 경고를 무시합니다.
    protected GradeInformation(
            final Instant issueDate,
            final String issueNo,
            final String judgeKindCd,
            final String raterCode,
            final String raterNm,
            final Instant abattDate,
            final String abattNm,
            final Instant judgeDate,
            final String abattCode,
            final String abattAddr,
            final String abattTelNo,
            final String reqUserNm,
            final String reqRegNo,
            final String reqComNm,
            final String reqAddr,
            final String reqTelNo,
            final String liveStockNm,
            final String abattFno,
            final String abattTno,
            final String judgeBreedNm,
            final String judgeSexNm,
            final String weight,
            final String gradeCd,
            final String gradeNm,
            final String costAmt
    ) {
        this.issueDate = issueDate;
        this.issueNo = issueNo;
        this.judgeKindCd = judgeKindCd;
        this.raterCode = raterCode;
        this.raterNm = raterNm;
        this.abattDate = abattDate;
        this.abattNm = abattNm;
        this.judgeDate = judgeDate;
        this.abattCode = abattCode;
        this.abattAddr = abattAddr;
        this.abattTelNo = abattTelNo;
        this.reqUserNm = reqUserNm;
        this.reqRegNo = reqRegNo;
        this.reqComNm = reqComNm;
        this.reqAddr = reqAddr;
        this.reqTelNo = reqTelNo;
        this.liveStockNm = liveStockNm;
        this.abattFno = abattFno;
        this.abattTno = abattTno;
        this.judgeBreedNm = judgeBreedNm;
        this.judgeSexNm = judgeSexNm;
        this.weight = weight;
        this.gradeCd = gradeCd;
        this.gradeNm = gradeNm;
        this.costAmt = costAmt;
    }

    /**
     * @return 발급일자
     */
    public Instant getIssueDate() {
        return issueDate;
    }

    /**
     * @return 발급번호
     */
    public String getIssueNo() {
        return issueNo;
    }

    /**
     * @return 품종코드
     */
    public String getJudgeKindCd() {
        return judgeKindCd;
    }

    /**
     * @return 평가사코드
     */
    public String getRaterCode() {
        return raterCode;
    }

    /**
     * @return 평가사명
     */
    public String getRaterNm() {
        return raterNm;
    }

    /**
     * @return 도축일자
     */
    public Instant getAbattDate() {
        return abattDate;
    }

    /**
     * @return 도축장명
     */
    public String getAbattNm() {
        return abattNm;
    }

    /**
     * @return 등급판정일자
     */
    public Instant getJudgeDate() {
        return judgeDate;
    }

    /**
     * @return 도축장코드
     */
    public String getAbattCode() {
        return abattCode;
    }

    /**
     * @return 도축장주소
     */
    public String getAbattAddr() {
        return abattAddr;
    }

    /**
     * @return 도축장전화번호
     */
    public String getAbattTelNo() {
        return abattTelNo;
    }

    /**
     * @return 신청인명
     */
    public String getReqUserNm() {
        return reqUserNm;
    }

    /**
     * @return 신청업체사업자번호
     */
    public String getReqRegNo() {
        return reqRegNo;
    }

    /**
     * @return 신청업체명
     */
    public String getReqComNm() {
        return reqComNm;
    }

    /**
     * @return 신청업체주소명
     */
    public String getReqAddr() {
        return reqAddr;
    }

    /**
     * @return 신청업체전화번호
     */
    public String getReqTelNo() {
        return reqTelNo;
    }

    /**
     * @return 축종명
     */
    public String getLiveStockNm() {
        return liveStockNm;
    }

    /**
     * @return 도축시작번호
     */
    public String getAbattFno() {
        return abattFno;
    }

    /**
     * @return 도축종료번호
     */
    public String getAbattTno() {
        return abattTno;
    }

    /**
     * @return 등급판정품종
     */
    public String getJudgeBreedNm() {
        return judgeBreedNm;
    }

    /**
     * @return 등급판정성별
     */
    public String getJudgeSexNm() {
        return judgeSexNm;
    }

    /**
     * @return 도체중량
     */
    public String getWeight() {
        return weight;
    }

    /**
     * @return 등급코드
     */
    public String getGradeCd() {
        return gradeCd;
    }

    /**
     * @return 등급명
     */
    public String getGradeNm() {
        return gradeNm;
    }

    /**
     * @return 경락가격
     */
    public String getCostAmt() {
        return costAmt;
    }
}
