package com.sirloin.mtraceapiclient.api.grade.confirm;

import com.sirloin.mtraceapiclient.api.grade.confirm.model.GradeConfirmInformation;
import com.sirloin.mtraceapiclient.internal.http.MtraceHttpClient;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * 축산물등급판정확인서 발급정보 api 인터페이스입니다.
 */
public interface GradeConfirm {
    /**
     * 축산물등급판정확인서 발급정보 api입니다.
     *
     * @param animalNo 소/돼지 이력정보입니다
     * @return GradeConfirmInformation
     */
    GradeConfirmInformation gradeConfirm(
            String animalNo
    ) throws IOException, ParserConfigurationException, SAXException;

    /**
     * 축산물등급판정확인서 발급정보 인터페이스 기본 생성자입니다.
     *
     * @param serviceKey : 공공데이터포털에서 받은 인증키입니다 decoding된 key를 입력하여주세요 required
     * @return GradeConfirm
     */
    static GradeConfirm newInstance(String serviceKey) {
        return new GradeConfirmImpl(
                MtraceHttpClient.newInstance(),
                serviceKey
        );
    }
}
