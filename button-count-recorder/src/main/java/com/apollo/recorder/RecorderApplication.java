package com.apollo.recorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class RecorderApplication {

    public static void main(final String[] args) {
	SpringApplication.run(RecorderApplication.class, args);
    }

}
