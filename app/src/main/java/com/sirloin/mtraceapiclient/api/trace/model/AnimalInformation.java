package com.sirloin.mtraceapiclient.api.trace.model;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Instant;

/**
 * 조회한 동물의 개체의 정보.
 */
public class AnimalInformation {
    /**
     * 출생일자.
     */
    @Nonnull
    private final Instant birthYmd;
    /**
     * 소 개체번호.
     */
    @Nullable
    private final String cattleNo;
    /**
     * 돼지 개체번호.
     */
    @Nullable
    private final String pigNo;
    /**
     * 농장번호.
     */
    @Nonnull
    private final String farmNo;
    /**
     * 농장식별번호.
     */
    @Nonnull
    private final String farmUniqueNo;
    /**
     * 조회정보 옵션값.
     */
    private final int infoType;
    /**
     * 소의 종류.
     */
    @Nonnull
    private  final String lsTypeNm;
    /**
     * 수입경과월.
     */
    private final int monthDiff;
    /**
     * 성별.
     */
    @Nonnull
    private final String sexNm;
    /**
     * 소/돼지/묶음 구분.
     */
    @Nonnull
    private final String traceNoType;

    /**
     * 조회한 동물의 개체의 정보.
     *
     * @param birthYmd     출생일자
     * @param cattleNo     소 개체번호
     * @param pigNo        돼지 개체번호
     * @param farmNo       농장번호
     * @param farmUniqueNo 농장식별번호
     * @param infoType     조회정보 옵션값
     * @param lsTypeNm     소의 종류
     * @param monthDiff    수입경과월
     * @param sexNm        성별
     * @param traceNoType  소/돼지/묶음 구분.
     */
    public AnimalInformation(
            final @Nonnull Instant birthYmd,
            final @Nullable String cattleNo,
            final @Nullable String pigNo,
            final @Nonnull String farmNo,
            final @Nonnull String farmUniqueNo,
            final int infoType,
            final @Nonnull String lsTypeNm,
            final int monthDiff,
            final @Nonnull String sexNm,
            final @Nonnull String traceNoType
    ) {
        this.birthYmd = birthYmd;
        this.cattleNo = cattleNo;
        this.pigNo = pigNo;
        this.farmNo = farmNo;
        this.farmUniqueNo = farmUniqueNo;
        this.infoType = infoType;
        this.lsTypeNm = lsTypeNm;
        this.monthDiff = monthDiff;
        this.sexNm = sexNm;
        this.traceNoType = traceNoType;
    }

    /**
     * @return 출생일자
     */
    @Nonnull
    public Instant getBirthYmd() {
        return birthYmd;
    }
    /**
     * @return 소 개체번호
     */
    @Nullable
    public String getCattleNo() {
        return cattleNo;
    }

    /**
     * @return 돼지 개체번호
     */
    @Nullable
    public String getPigNo() {
        return pigNo;
    }

    /**
     * @return 농장번호
     */
    @Nonnull
    public String getFarmNo() {
        return farmNo;
    }

    /**
     * @return 농장식별번호
     */
    @Nonnull
    public String getFarmUniqueNo() {
        return farmUniqueNo;
    }

    /**
     * @return 조회정보 옵션값
     */
    public int getInfoType() {
        return infoType;
    }

    /**
     * @return 소의 종류
     */
    @Nonnull
    public String getLsTypeNm() {
        return lsTypeNm;
    }

    /**
     * @return 수입경과월
     */
    public int getMonthDiff() {
        return monthDiff;
    }

    /**
     * @return 성별
     */
    @Nonnull
    public String getSexNm() {
        return sexNm;
    }

    /**
     * @return 소/돼지/묶음 구분
     */
    @Nonnull
    public String getTraceNoType() {
        return traceNoType;
    }
}
