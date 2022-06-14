package com.sirloin.mtraceapiclient.api.trace.model;

import javax.annotation.Nullable;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 통합이력정보 조회 결과입니다.
 *
 * @param animalInformation 조회한 동물의 개체의 정보
 * @param farmInformation 출생 등 신고정보
 * @param butcheryInformation 도축장 정보
 * @param processPlaceInformation 포장처리 정보
 * @param injectionInformation 백신접종 정보
 * @param inspectInformation 가축질병 검사 정보
 */
public record TraceResult(
        @Nullable AnimalInformation animalInformation,
        @NotNull List<FarmInformation> farmInformation,
        @Nullable ButcheryInformation butcheryInformation,
        @Nullable ProcessPlaceInformation processPlaceInformation,
        @Nullable InjectionInformation injectionInformation,
        @Nullable InspectInformation inspectInformation
) {
    /**
     * 통합이력정보 조회 결과입니다.
     *
     * @param animalInformation 조회한 동물의 개체의 정보
     * @param farmInformation 출생 등 신고정보
     * @param butcheryInformation 도축장 정보
     * @param processPlaceInformation 포장처리 정보
     * @param injectionInformation 백신접종 정보
     * @param inspectInformation 가축질병 검사 정보
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
}
