package com.sirloin.mtraceapiclient.api.grade.information.model;


import java.time.Instant;

/**
 * 소 등급 판정 정보입니다.
 */
public class CattleGradeInformation extends GradeInformation {
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
     *  소 등급 판정 정보 기본 생성자입니다.
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
        super(
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
                costAmt
        );
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
}
