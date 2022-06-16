package com.sirloin.mtraceapiclient.api.trace.model;

import javax.annotation.Nonnull;
import java.time.ZonedDateTime;
import java.util.Objects;

/**
 * 백신접종 정보.
 */
public class InjectionInformation {
    /**
     * 구제역 예방접종최종일자.
     */
    @Nonnull
    private final ZonedDateTime injectionYmd;
    /**
     * 구제역 백신접종경과일.
     */
    @Nonnull
    private final String injectiondayCnt;
    /**
     * 구제역 백신접종 차수.
     */
    @Nonnull
    private final String vaccineorder;
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
     * 백신접종 정보.
     *
     * @param injectionYmd    구제역 예방접종최종일자
     * @param injectiondayCnt 구제역 백신접종경과일
     * @param vaccineorder    구제역 백신접종 차수
     * @param infoType        조회정보
     * @param traceNoType     소/돼지/묶음 구분
     */
    public InjectionInformation(
            @Nonnull final ZonedDateTime injectionYmd,
            @Nonnull final String injectiondayCnt,
            @Nonnull final String vaccineorder,
            final int infoType,
            @Nonnull final String traceNoType
    ) {
        this.injectionYmd = injectionYmd;
        this.injectiondayCnt = injectiondayCnt;
        this.vaccineorder = vaccineorder;
        this.infoType = infoType;
        this.traceNoType = traceNoType;
    }

    /**
     * @return 구제역 예방접종최종일자.
     */
    @Nonnull
    public ZonedDateTime getInjectionYmd() {
        return injectionYmd;
    }

    /**
     * @return 구제역 백신접종경과일.
     */
    @Nonnull
    public String getInjectiondayCnt() {
        return injectiondayCnt;
    }

    /**
     * @return 구제역 백신접종 차수.
     */
    @Nonnull
    public String getVaccineorder() {
        return vaccineorder;
    }

    /**
     * @return 조회정보.
     */
    public int getInfoType() {
        return infoType;
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
        InjectionInformation that = (InjectionInformation) o;
        return infoType == that.infoType
                && injectionYmd.equals(that.injectionYmd)
                && injectiondayCnt.equals(that.injectiondayCnt)
                && vaccineorder.equals(that.vaccineorder)
                && traceNoType.equals(that.traceNoType);
    }

    /**
     * 기본 해쉬코드.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(injectionYmd, injectiondayCnt, vaccineorder, infoType, traceNoType);
    }
}
