package com.sirloin.mtraceapiclient.api.trace.model;

import javax.annotation.Nonnull;
import java.time.Instant;
import java.util.Objects;

/**
 * 출생 등 신고정보.
 */
public class FarmInformation {
    /**
     * 농장주소.
     */
    @Nonnull
    private final String farmAddr;
    /**
     * 농장번호.
     */
    @Nonnull
    private final String farmNo;
    /**
     * 소유주 이름.
     */
    @Nonnull
    private final String farmerNm;
    /**
     * 조회정보 .
     */
    private final int infoType;
    /**
     * 전산등록.
     */
    @Nonnull
    private final String regType;
    /**
     * 신고년월일 .
     */
    @Nonnull
    private final Instant regYmd;
    /**
     * 소/돼지/묶음 구분.
     */
    @Nonnull
    private final String traceNoType;

    /**
     * 출생 등 신고정보.
     *
     * @param farmAddr    농장주소
     * @param farmNo      농장번호
     * @param farmerNm    소유주
     * @param infoType    조회정보
     * @param regType     전산등록
     * @param regYmd      신고년월일
     * @param traceNoType 소/돼지/묶음 구분
     */
    public FarmInformation(
            @Nonnull final String farmAddr,
            @Nonnull final String farmNo,
            @Nonnull final String farmerNm,
            final int infoType,
            @Nonnull final String regType,
            @Nonnull final Instant regYmd,
            @Nonnull final String traceNoType
    ) {
        this.farmAddr = farmAddr;
        this.farmNo = farmNo;
        this.farmerNm = farmerNm;
        this.infoType = infoType;
        this.regType = regType;
        this.regYmd = regYmd;
        this.traceNoType = traceNoType;
    }

    /**
     * @return 농장주소
     */
    @Nonnull
    public String getFarmAddr() {
        return farmAddr;
    }

    /**
     * @return 농장번호
     */
    @Nonnull
    public String getFarmNo() {
        return farmNo;
    }

    /**
     * @return 소유주
     */
    @Nonnull
    public String getFarmerNm() {
        return farmerNm;
    }

    /**
     * @return 조회정보
     */
    public int getInfoType() {
        return infoType;
    }

    /**
     * @return 전산등록
     */
    @Nonnull
    public String getRegType() {
        return regType;
    }

    /**
     * @return 신고년월일
     */
    @Nonnull
    public Instant getRegYmd() {
        return regYmd;
    }

    /**
     * @return 소/돼지/묶음 구분
     */
    @Nonnull
    public String getTraceNoType() {
        return traceNoType;
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
        FarmInformation that = (FarmInformation) o;
        return infoType == that.infoType
                && farmAddr.equals(that.farmAddr)
                && farmNo.equals(that.farmNo)
                && farmerNm.equals(that.farmerNm)
                && regType.equals(that.regType)
                && regYmd.equals(that.regYmd)
                && traceNoType.equals(that.traceNoType);
    }

    /**
     * 기본 해쉬코드.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(farmAddr, farmNo, farmerNm, infoType, regType, regYmd, traceNoType);
    }
}

