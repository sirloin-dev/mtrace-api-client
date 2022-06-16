package com.sirloin.mtraceapiclient.api.trace.model;

import javax.annotation.Nonnull;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * 가축질병 검사 정보.
 */
public class InspectInformation {
    /**
     * 브루셀라 검사최종일자.
     */
    @Nonnull
    private final ZonedDateTime inspectDt;
    /**
     * 음성 or 양성.
     */
    @Nonnull
    private final String inspectYn;
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
     * 가축질병 검사 정보.
     *
     * @param inspectDt   브루셀라 검사최종일자
     * @param inspectYn   음성 or 양성
     * @param infoType    조회정보
     * @param traceNoType 소/돼지/묶음 구분
     */
    public InspectInformation(
            @Nonnull final ZonedDateTime inspectDt,
            @Nonnull final String inspectYn,
            final int infoType,
            @Nonnull final String traceNoType
    ) {
        this.inspectDt = inspectDt;
        this.inspectYn = inspectYn;
        this.infoType = infoType;
        this.traceNoType = traceNoType;
    }

    /**
     * @return 브루셀라 검사최종일자
     */
    @Nonnull
    public ZonedDateTime getInspectDt() {
        return inspectDt;
    }

    /**
     * @return 음성 or 양성
     */
    @Nonnull
    public String getInspectYn() {
        return inspectYn;
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
        InspectInformation that = (InspectInformation) o;
        return infoType == that.infoType
                && inspectDt.equals(that.inspectDt)
                && inspectYn.equals(that.inspectYn)
                && traceNoType.equals(that.traceNoType);
    }

    /**
     * 기본 해쉬코드.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(inspectDt, inspectYn, infoType, traceNoType);
    }
}
