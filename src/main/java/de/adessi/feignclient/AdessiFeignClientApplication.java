package de.adessi.feignclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AdessiFeignClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdessiFeignClientApplication.class, args);
    }

}
