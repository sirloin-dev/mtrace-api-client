package com.sirloin.mtraceapiclient.api.grade.information;

import com.sirloin.mtraceapiclient.api.grade.information.model.CattleGradeInformation;
import com.sirloin.mtraceapiclient.api.grade.information.model.GradeInformation;
import com.sirloin.mtraceapiclient.internal.http.MtraceHttpClient;

/**
 * 등급판정결과(확인서)정보 인터페이스입니다.
 *
 * @param <T> GradeInformation를 상속받은 개체별 등급정보 입니다.
 */
public interface Grade<T extends GradeInformation> {
    /**
     * 등급판정결과(확인서 정보) 입니다.
     *
     * @param issueNo      확인서 번호
     * @param issueDateStr 확인서 발급일 String 형태 yyyy-mm-dd 형식의 String 이어야 한다.
     * @param serviceKey   서비스 인증키
     * @return GradeInformation
     */
    T grade(String issueNo, String issueDateStr, String serviceKey) throws Exception;


    /**
     * 소 등급판정결과(확인서 정보) 입니다.
     * <p>
     * 추후 닭 돼지 등으로 확장 될 수 있어 type을 지정합니다.
     *
     * @return GradeCattleImpl
     */
    static Grade<CattleGradeInformation> cattleInstance() {
        return new GradeCattleImpl(
                MtraceHttpClient.newInstance()
        );
    }
}
