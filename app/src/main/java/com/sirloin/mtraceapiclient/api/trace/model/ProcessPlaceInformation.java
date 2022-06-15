package com.sirloin.mtraceapiclient.api.trace.model;


import javax.annotation.Nonnull;

/**
 * 포장처리 정보.
 */
public class ProcessPlaceInformation {
    /**
     * 포장처리업소 주소.
     */
    @Nonnull
    private final String processPlaceAddr;
    /**
     * 포장처리업소명.
     */
    @Nonnull
    private final String processPlaceNm;
    /**
     * 조회정보.
     */
    private final int infoType;
    /**
     * 소/돼지/묶음 구분.
     */
    @Nonnull
    private final String traceNoType;

    /**
     * 포장처리 정보.
     *
     * @param processPlaceAddr 포장처리업소 주소
     * @param processPlaceNm   포장처리업소명
     * @param infoType         조회정보
     * @param traceNoType      소/돼지/묶음 구분
     */
    public ProcessPlaceInformation(
            @Nonnull final String processPlaceAddr,
            @Nonnull final String processPlaceNm,
            final int infoType,
            @Nonnull final String traceNoType
    ) {
        this.processPlaceAddr = processPlaceAddr;
        this.processPlaceNm = processPlaceNm;
        this.infoType = infoType;
        this.traceNoType = traceNoType;
    }

    /**
     * @return 포장처리업소 주소
     */
    @Nonnull
    public String getProcessPlaceAddr() {
        return processPlaceAddr;
    }

    /**
     * @return 포장처리업소명
     */
    @Nonnull
    public String getProcessPlaceNm() {
        return processPlaceNm;
    }

    /**
     * @return 조회정보
     */
    public int getInfoType() {
        return infoType;
    }

    /**
     * @return 소/돼지/묶음 구분
     */
    @Nonnull
    public String getTraceNoType() {
        return traceNoType;
    }
}
