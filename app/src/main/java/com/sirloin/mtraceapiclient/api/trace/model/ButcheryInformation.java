package com.sirloin.mtraceapiclient.api.trace.model;

import javax.annotation.Nonnull;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * 도축장 정보.
 */
public class ButcheryInformation {
    /**
     * 도축장 주소.
     */
    @Nonnull
    private final String butcheryPlaceAddr;
    /**
     * 도축장명.
     */
    @Nonnull
    private final String butcheryPlaceNm;
    /**
     * 도축일자.
     */
    @Nonnull
    private final ZonedDateTime butcheryYmd;
    /**
     * 등급명.
     */
    @Nonnull
    private final String gradeNm;
    /**
     * 조회정보.
     */
    private final int infoType;
    /**
     * 위생검사 결과.
     */
    @Nonnull
    private final String inspectPassYn;
    /**
     * 소/돼지/묶음 구분.
     */
    @Nonnull
    private final String traceNoType;

    /**
     * 도축장 정보.
     *
     * @param butcheryPlaceAddr 도축장 주소
     * @param butcheryPlaceNm   도축장명
     * @param butcheryYmd       도축일자
     * @param gradeNm           등급명
     * @param infoType          조회정보
     * @param inspectPassYn     위생검사 결과
     * @param traceNoType       소/돼지/묶음 구분
     */
    public ButcheryInformation(
            @Nonnull final String butcheryPlaceAddr,
            @Nonnull final String butcheryPlaceNm,
            @Nonnull final ZonedDateTime butcheryYmd,
            @Nonnull final String gradeNm,
            final int infoType,
            @Nonnull final String inspectPassYn,
            @Nonnull final String traceNoType
    ) {
        this.butcheryPlaceAddr = butcheryPlaceAddr;
        this.butcheryPlaceNm = butcheryPlaceNm;
        this.butcheryYmd = butcheryYmd;
        this.gradeNm = gradeNm;
        this.infoType = infoType;
        this.inspectPassYn = inspectPassYn;
        this.traceNoType = traceNoType;
    }

    /**
     * @return 도축장 주소
     */
    @Nonnull
    public String getButcheryPlaceAddr() {
        return butcheryPlaceAddr;
    }

    /**
     * @return 도축장명
     */
    @Nonnull
    public String getButcheryPlaceNm() {
        return butcheryPlaceNm;
    }

    /**
     * @return 도축일자
     */
    @Nonnull
    public ZonedDateTime getButcheryYmd() {
        return butcheryYmd;
    }

    /**
     * @return 등급명
     */
    @Nonnull
    public String getGradeNm() {
        return gradeNm;
    }

    /**
     * @return 조회정보
     */
    public int getInfoType() {
        return infoType;
    }

    /**
     * @return 위생검사 결과
     */
    @Nonnull
    public String getInspectPassYn() {
        return inspectPassYn;
    }

    /**
     * @return 소/돼지/묶음 구분.
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
        ButcheryInformation that = (ButcheryInformation) o;
        return infoType == that.infoType
                && butcheryPlaceAddr.equals(that.butcheryPlaceAddr)
                && butcheryPlaceNm.equals(that.butcheryPlaceNm)
                && butcheryYmd.equals(that.butcheryYmd)
                && gradeNm.equals(that.gradeNm)
                && inspectPassYn.equals(that.inspectPassYn)
                && traceNoType.equals(that.traceNoType);
    }

    /**
     * 기본 해쉬코드.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(
                butcheryPlaceAddr,
                butcheryPlaceNm,
                butcheryYmd,
                gradeNm,
                infoType,
                inspectPassYn,
                traceNoType
        );
    }
}
