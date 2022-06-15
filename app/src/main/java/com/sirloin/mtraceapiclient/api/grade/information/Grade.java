package com.sirloin.mtraceapiclient.api.grade.information;

import com.sirloin.mtraceapiclient.api.grade.information.model.CattleGradeInformation;
import com.sirloin.mtraceapiclient.api.grade.information.model.GradeInformation;
import com.sirloin.mtraceapiclient.internal.http.MtraceHttpClient;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * 등급판정결과(확인서)정보 인터페이스입니다.
 * <p>
 * 등급 판정 결과정보는 소, 돼지, 닭, 말 등 의 여러 api가 있습니다.
 * 해당 api들의 공통정보를 GradeInformation를 super type화하고 각 세부 정보를 구현체에서 리턴하는 방법으로 생각하였습니다.
 *
 * @param <T> GradeInformation를 상속받은 개체별 등급정보 입니다.
 */
public interface Grade<T extends GradeInformation> {
    /**
     * 등급판정결과(확인서 정보) 입니다.
     *
     * @param issueNo      확인서 번호
     * @param issueDateStr 확인서 발급일 String 형태 yyyy-mm-dd 형식의 String 이어야 한다.
     * @return GradeInformation
     */
    T grade(String issueNo, String issueDateStr) throws IOException, ParserConfigurationException, SAXException;


    /**
     * 소 등급판정결과(확인서 정보) 입니다.
     * <p>
     * 추후 닭 돼지 등으로 확장 될 수 있어 type을 지정합니다.
     *
     * @param serviceKey : 공공데이터포털에서 받은 인증키입니다 decoding된 key를 입력하여주세요 required
     * @return GradeCattleImpl
     */
    static Grade<CattleGradeInformation> cattleInstance(String serviceKey) {
        return new GradeCattleImpl(
                MtraceHttpClient.newInstance(),
                serviceKey
        );
    }
}
