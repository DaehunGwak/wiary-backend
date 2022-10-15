package io.wiary.wiarybackend.opendata.client;

import io.wiary.wiarybackend.opendata.model.type.OpenDataWeatherResponseType;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Disabled("정상 응답 학습 테스트")
@SpringBootTest
@ActiveProfiles("local")
class OpenDataWeatherClientTest {

    @Autowired
    private OpenDataWeatherClient openDataWeatherClient;

    @Value("${external.open-data.authentication-key}")
    private String openDataAuthKey;

    @Test
    void getWeatherLive() {
        openDataWeatherClient.getWeatherLive(openDataAuthKey,
                10,
                1,
                OpenDataWeatherResponseType.JSON,
                "20221015",
                "1900",
                55,
                127);
    }
}