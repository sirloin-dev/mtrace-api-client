package com.sirloin.mtraceapiclient.api.grade.information.model;


import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * 소 등급 판정 정보입니다.
 */
public class CattleGradeInformation implements GradeInformation {
    /**
     * 발급일자.
     */
    private final ZonedDateTime issueDate;
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
    private final ZonedDateTime abattDate;
    /**
     * 도축장명.
     */
    private final String abattNm;
    /**
     * 등급판정일자.
     */
    private final ZonedDateTime judgeDate;
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
    /**
     * 육량지수.
     */
    private final String windex;
    /**
     * 육질등급.
     */
    private final String qgrade;
    /**
     * 육량등급.
     */
    private final String wgrade;
    /**
     * 확인서발급두수.
     */
    private final int issueCnt;
    /**
     * 소 이력번호.
     */
    private final String cattleNo;
    /**
     * 등지방두깨.
     */
    private final String backfat;
    /**
     * 등심단면적.
     */
    private final String rea;
    /**
     * 육색.
     */
    private final String yuksak;
    /**
     * 지방색.
     */
    private final String fatsak;
    /**
     * 성숙도.
     */
    private final String growth;
    /**
     * 조직감.
     */
    private final String tissue;
    /**
     * 근내지방도.
     */
    private final String insfat;
    /**
     * 출하월령.
     */
    private final String birthMonth;

    /**
     * 소 등급 판정 정보 기본 생성자입니다.
     * <p>
     * builder를 사용하지않은 이유는 수많은 필드중 필수값이 누락될 경우 컴파일 타임에 알 수 없어 배제하였습니다.
     *
     * @param issueDate
     * @param issueNo
     * @param judgeKindCd
     * @param raterCode
     * @param raterNm
     * @param abattDate
     * @param abattNm
     * @param judgeDate
     * @param abattCode
     * @param abattAddr
     * @param abattTelNo
     * @param reqUserNm
     * @param reqRegNo
     * @param reqComNm
     * @param reqAddr
     * @param reqTelNo
     * @param liveStockNm
     * @param abattFno
     * @param abattTno
     * @param judgeBreedNm
     * @param judgeSexNm
     * @param weight
     * @param gradeCd
     * @param gradeNm
     * @param costAmt
     * @param windex
     * @param qgrade
     * @param wgrade
     * @param issueCnt
     * @param cattleNo
     * @param backfat
     * @param rea
     * @param yuksak
     * @param fatsak
     * @param growth
     * @param tissue
     * @param insfat
     * @param birthMonth
     */
    @SuppressWarnings("checkstyle:parameternumber") // api의 parameter의 갯수가 많아 해당 경고를 무시합니다.
    public CattleGradeInformation(
            final ZonedDateTime issueDate,
            final String issueNo,
            final String judgeKindCd,
            final String raterCode,
            final String raterNm,
            final ZonedDateTime abattDate,
            final String abattNm,
            final ZonedDateTime judgeDate,
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
            final String costAmt,
            final String windex,
            final String qgrade,
            final String wgrade,
            final int issueCnt,
            final String cattleNo,
            final String backfat,
            final String rea,
            final String yuksak,
            final String fatsak,
            final String growth,
            final String tissue,
            final String insfat,
            final String birthMonth
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
        this.windex = windex;
        this.qgrade = qgrade;
        this.wgrade = wgrade;
        this.issueCnt = issueCnt;
        this.cattleNo = cattleNo;
        this.backfat = backfat;
        this.rea = rea;
        this.yuksak = yuksak;
        this.fatsak = fatsak;
        this.growth = growth;
        this.tissue = tissue;
        this.insfat = insfat;
        this.birthMonth = birthMonth;
    }


    /**
     * @return 발급일자
     */
    @Override
    public ZonedDateTime getIssueDate() {
        return issueDate;
    }

    /**
     * @return 발급번호
     */
    @Override
    public String getIssueNo() {
        return issueNo;
    }

    /**
     * @return 품종코드
     */
    @Override
    public String getJudgeKindCd() {
        return judgeKindCd;
    }

    /**
     * @return 평가사코드
     */
    @Override
    public String getRaterCode() {
        return raterCode;
    }

    /**
     * @return 평가사명
     */
    @Override
    public String getRaterNm() {
        return raterNm;
    }

    /**
     * @return 도축일자
     */
    @Override
    public ZonedDateTime getAbattDate() {
        return abattDate;
    }

    /**
     * @return 도축장명
     */
    @Override
    public String getAbattNm() {
        return abattNm;
    }

    /**
     * @return 등급판정일자
     */
    @Override
    public ZonedDateTime getJudgeDate() {
        return judgeDate;
    }

    /**
     * @return 도축장코드
     */
    @Override
    public String getAbattCode() {
        return abattCode;
    }

    /**
     * @return 도축장주소
     */
    @Override
    public String getAbattAddr() {
        return abattAddr;
    }

    /**
     * @return 도축장전화번호
     */
    @Override
    public String getAbattTelNo() {
        return abattTelNo;
    }

    /**
     * @return 신청인명
     */
    @Override
    public String getReqUserNm() {
        return reqUserNm;
    }

    /**
     * @return 신청업체사업자번호
     */
    @Override
    public String getReqRegNo() {
        return reqRegNo;
    }

    /**
     * @return 신청업체명
     */
    @Override
    public String getReqComNm() {
        return reqComNm;
    }

    /**
     * @return 신청업체주소명
     */
    @Override
    public String getReqAddr() {
        return reqAddr;
    }

    /**
     * @return 신청업체전화번호
     */
    @Override
    public String getReqTelNo() {
        return reqTelNo;
    }

    /**
     * @return 축종명
     */
    @Override
    public String getLiveStockNm() {
        return liveStockNm;
    }

    /**
     * @return 도축시작번호
     */
    @Override
    public String getAbattFno() {
        return abattFno;
    }

    /**
     * @return 도축종료번호
     */
    @Override
    public String getAbattTno() {
        return abattTno;
    }

    /**
     * @return 등급판정품종
     */
    @Override
    public String getJudgeBreedNm() {
        return judgeBreedNm;
    }

    /**
     * @return 등급판정성별
     */
    @Override
    public String getJudgeSexNm() {
        return judgeSexNm;
    }

    /**
     * @return 도체중량
     */
    @Override
    public String getWeight() {
        return weight;
    }

    /**
     * @return 등급코드
     */
    @Override
    public String getGradeCd() {
        return gradeCd;
    }

    /**
     * @return 등급명
     */
    @Override
    public String getGradeNm() {
        return gradeNm;
    }

    /**
     * @return 경락가격
     */
    @Override
    public String getCostAmt() {
        return costAmt;
    }

    /**
     * @return 육량지수.
     */
    public String getWindex() {
        return windex;
    }

    /**
     * @return 육질등급.
     */
    public String getQgrade() {
        return qgrade;
    }

    /**
     * @return 육량등급.
     */
    public String getWgrade() {
        return wgrade;
    }

    /**
     * @return 확인서발급두수.
     */
    public int getIssueCnt() {
        return issueCnt;
    }

    /**
     * @return 소 이력번호.
     */
    public String getCattleNo() {
        return cattleNo;
    }

    /**
     * @return 등지방두깨.
     */
    public String getBackfat() {
        return backfat;
    }

    /**
     * @return 등심단면적.
     */
    public String getRea() {
        return rea;
    }

    /**
     * @return 육색.
     */
    public String getYuksak() {
        return yuksak;
    }

    /**
     * @return 지방색.
     */
    public String getFatsak() {
        return fatsak;
    }

    /**
     * @return 성숙도.
     */
    public String getGrowth() {
        return growth;
    }

    /**
     * @return 조직감.
     */
    public String getTissue() {
        return tissue;
    }

    /**
     * @return 근내지방도.
     */
    public String getInsfat() {
        return insfat;
    }

    /**
     * @return 출하월령.
     */
    public String getBirthMonth() {
        return birthMonth;
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
        CattleGradeInformation that = (CattleGradeInformation) o;
        return issueCnt == that.issueCnt
                && Objects.equals(issueDate, that.issueDate)
                && Objects.equals(issueNo, that.issueNo)
                && Objects.equals(judgeKindCd, that.judgeKindCd)
                && Objects.equals(raterCode, that.raterCode)
                && Objects.equals(raterNm, that.raterNm)
                && Objects.equals(abattDate, that.abattDate)
                && Objects.equals(abattNm, that.abattNm)
                && Objects.equals(judgeDate, that.judgeDate)
                && Objects.equals(abattCode, that.abattCode)
                && Objects.equals(abattAddr, that.abattAddr)
                && Objects.equals(abattTelNo, that.abattTelNo)
                && Objects.equals(reqUserNm, that.reqUserNm)
                && Objects.equals(reqRegNo, that.reqRegNo)
                && Objects.equals(reqComNm, that.reqComNm)
                && Objects.equals(reqAddr, that.reqAddr)
                && Objects.equals(reqTelNo, that.reqTelNo)
                && Objects.equals(liveStockNm, that.liveStockNm)
                && Objects.equals(abattFno, that.abattFno)
                && Objects.equals(abattTno, that.abattTno)
                && Objects.equals(judgeBreedNm, that.judgeBreedNm)
                && Objects.equals(judgeSexNm, that.judgeSexNm)
                && Objects.equals(weight, that.weight)
                && Objects.equals(gradeCd, that.gradeCd)
                && Objects.equals(gradeNm, that.gradeNm)
                && Objects.equals(costAmt, that.costAmt)
                && Objects.equals(windex, that.windex)
                && Objects.equals(qgrade, that.qgrade)
                && Objects.equals(wgrade, that.wgrade)
                && Objects.equals(cattleNo, that.cattleNo)
                && Objects.equals(backfat, that.backfat)
                && Objects.equals(rea, that.rea)
                && Objects.equals(yuksak, that.yuksak)
                && Objects.equals(fatsak, that.fatsak)
                && Objects.equals(growth, that.growth)
                && Objects.equals(tissue, that.tissue)
                && Objects.equals(insfat, that.insfat)
                && Objects.equals(birthMonth, that.birthMonth);
    }

    /**
     * 기본 해쉬코드.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(
                issueDate,
                issueNo,
                judgeKindCd,
                raterCode,
                raterNm,
                abattDate,
                abattNm,
                judgeDate,
                abattCode,
                abattAddr,
                abattTelNo,
                reqUserNm,
                reqRegNo,
                reqComNm,
                reqAddr,
                reqTelNo,
                liveStockNm,
                abattFno,
                abattTno,
                judgeBreedNm,
                judgeSexNm,
                weight,
                gradeCd,
                gradeNm,
                costAmt,
                windex,
                qgrade,
                wgrade,
                issueCnt,
                cattleNo,
                backfat,
                rea,
                yuksak,
                fatsak,
                growth,
                tissue,
                insfat,
                birthMonth
        );
    }
}
