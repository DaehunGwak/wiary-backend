package io.wiary.wiarybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class WiaryBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(WiaryBackendApplication.class, args);
    }

}
