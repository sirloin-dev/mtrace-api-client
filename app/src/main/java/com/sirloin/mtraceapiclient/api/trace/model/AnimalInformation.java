package com.sirloin.mtraceapiclient.api.trace.model;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.time.Instant;

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
public record AnimalInformation(
        @Nonnull Instant birthYmd,
        @Nullable String cattleNo,
        @Nullable String pigNo,
        @Nonnull String farmNo,
        @Nonnull String farmUniqueNo,
        int infoType,
        @Nonnull String lsTypeNm,
        int monthDiff,
        @Nonnull String sexNm,
        @Nonnull String traceNoType
) {

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
}
