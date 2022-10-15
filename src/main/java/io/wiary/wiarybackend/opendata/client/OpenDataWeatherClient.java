package io.wiary.wiarybackend.opendata.client;

import io.wiary.wiarybackend.opendata.model.response.OpenDataWeatherLiveResponse;
import io.wiary.wiarybackend.opendata.model.type.OpenDataWeatherResponseType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 공공데이터 날씨 api feign client
 * 참고자료:
 * - 공공데이터 날씨 api spec: https://www.data.go.kr/data/15084084/openapi.do
 * - feign client guide : https://cloud.spring.io/spring-cloud-netflix/multi/multi_spring-cloud-feign.html
 */
@FeignClient(name = "openDataWeather", url = "${external.open-data.base-url}")
public interface OpenDataWeatherClient {

    /**
     * 초단기 실활 조회 서비스 api
     * - 주의사항: hh00 에 발표한 날씨 현황은 hh40 이후에 조회할 수 있다.
     *
     * @param serviceKey 공공데이터 포털에서 받은 인증키
     * @param numOfRows 한 페이지 결과 수 (default 10)
     * @param pageNo 페이지 번호 (default 1)
     * @param responseType 응답 타입 (JSON, XML)
     * @param baseDate 발표 날짜 (format: yyyyMMdd)
     * @param baseTime 발표 시간 (format: hhmm)
     * @param nx 예보지점 X 좌표값
     * @param ny 예보지점 Y 좌표값
     * @return OpenDataWeatherLiveResponse
     */
    @GetMapping("/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst")
    OpenDataWeatherLiveResponse getWeatherLive(@RequestParam("serviceKey") String serviceKey,
                                               @RequestParam("numOfRows") int numOfRows,
                                               @RequestParam("pageNo") int pageNo,
                                               @RequestParam("dataType") OpenDataWeatherResponseType responseType,
                                               @RequestParam("base_date") String baseDate,
                                               @RequestParam("base_time") String baseTime,
                                               @RequestParam("nx") int nx,
                                               @RequestParam("ny") int ny);
}
