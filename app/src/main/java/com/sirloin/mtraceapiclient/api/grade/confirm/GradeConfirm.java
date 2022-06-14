package com.sirloin.mtraceapiclient.api.grade.confirm;

import com.sirloin.mtraceapiclient.api.grade.confirm.model.GradeConfirmInformation;
import com.sirloin.mtraceapiclient.internal.http.MtraceHttpClient;

/**
 * 축산물등급판정확인서 발급정보 api 인터페이스입니다.
 */
public interface GradeConfirm {
    /**
     * 축산물등급판정확인서 발급정보 api입니다.
     *
     * @param animalNo   소/돼지 이력정보입니다
     * @param serviceKey 인증키입니다
     * @return GradeConfirmInformation
     */
    GradeConfirmInformation gradeConfirm(String animalNo, String serviceKey) throws Exception;

    /**
     * 축산물등급판정확인서 발급정보 인터페이스 기본 생성자입니다.
     *
     * @return GradeConfirm
     */
    static GradeConfirm newInstance() {
        return new GradeConfirmImpl(MtraceHttpClient.newInstance());
    }
}
