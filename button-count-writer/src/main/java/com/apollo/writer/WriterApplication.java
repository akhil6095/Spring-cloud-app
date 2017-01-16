package com.apollo.writer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class WriterApplication {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
	return new RestTemplate();
    }

    public static void main(final String[] args) {
	SpringApplication.run(WriterApplication.class, args);
    }

}
