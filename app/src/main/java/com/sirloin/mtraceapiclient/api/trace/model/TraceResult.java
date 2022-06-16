package com.sirloin.mtraceapiclient.api.trace.model;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 통합이력정보 조회 결과입니다.
 */
public class TraceResult {

    /**
     * 조회한 동물의 개체의 정보.
     */
    @Nullable
    private final AnimalInformation animalInformation;
    /**
     * 출생 등 신고정보.
     */
    @Nonnull
    private final List<FarmInformation> farmInformation;
    /**
     * 도축장 정보.
     */
    @Nullable
    private final ButcheryInformation butcheryInformation;
    /**
     * 포장처리 정보.
     */
    @Nullable
    private final ProcessPlaceInformation processPlaceInformation;
    /**
     * 백신접종 정보.
     */
    @Nullable
    private final InjectionInformation injectionInformation;
    /**
     * 가축질병 검사 정보.
     */
    @Nullable
    private final InspectInformation inspectInformation;

    /**
     * 통합이력정보 조회 결과입니다.
     *
     * @param animalInformation       조회한 동물의 개체의 정보
     * @param farmInformation         출생 등 신고정보
     * @param butcheryInformation     도축장 정보
     * @param processPlaceInformation 포장처리 정보
     * @param injectionInformation    백신접종 정보
     * @param inspectInformation      가축질병 검사 정보
     */
    public TraceResult(
            final @Nullable AnimalInformation animalInformation,
            final List<FarmInformation> farmInformation,
            final @Nullable ButcheryInformation butcheryInformation,
            final @Nullable ProcessPlaceInformation processPlaceInformation,
            final @Nullable InjectionInformation injectionInformation,
            final @Nullable InspectInformation inspectInformation
    ) {
        this.animalInformation = animalInformation;
        if (Objects.isNull(farmInformation)) {
            this.farmInformation = new ArrayList<>();
        } else {
            this.farmInformation = farmInformation;
        }
        this.butcheryInformation = butcheryInformation;
        this.processPlaceInformation = processPlaceInformation;
        this.injectionInformation = injectionInformation;
        this.inspectInformation = inspectInformation;
    }

    /**
     * @return 조회한 동물의 개체의 정보.
     */
    @Nullable
    public AnimalInformation getAnimalInformation() {
        return animalInformation;
    }

    /**
     * @return 출생 등 신고정보.
     */
    @Nonnull
    public List<FarmInformation> getFarmInformation() {
        return farmInformation;
    }

    /**
     * @return 도축장 정보.
     */
    @Nullable
    public ButcheryInformation getButcheryInformation() {
        return butcheryInformation;
    }

    /**
     * @return 포장처리 정보.
     */
    @Nullable
    public ProcessPlaceInformation getProcessPlaceInformation() {
        return processPlaceInformation;
    }

    /**
     * @return 백신접종 정보.
     */
    @Nullable
    public InjectionInformation getInjectionInformation() {
        return injectionInformation;
    }

    /**
     * @return 가축질병 검사 정보.
     */
    @Nullable
    public InspectInformation getInspectInformation() {
        return inspectInformation;
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
        TraceResult that = (TraceResult) o;
        return Objects.equals(animalInformation, that.animalInformation)
                && farmInformation.equals(that.farmInformation)
                && Objects.equals(butcheryInformation, that.butcheryInformation)
                && Objects.equals(processPlaceInformation, that.processPlaceInformation)
                && Objects.equals(injectionInformation, that.injectionInformation)
                && Objects.equals(inspectInformation, that.inspectInformation);
    }

    /**
     * 기본 해쉬코드.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        return Objects.hash(
                animalInformation,
                farmInformation,
                butcheryInformation,
                processPlaceInformation,
                injectionInformation,
                inspectInformation
        );
    }
}
