package io.game.sciroc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableEurekaClient
@EnableFeignClients("io.game.sciroc.service")
@SpringBootApplication
public class ScirocApplication {

    public static void main(String[] args) {
        SpringApplication.run(ScirocApplication.class, args);
    }
}
