package com.apollo.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class WebApplication {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
	return new RestTemplate();
    }

    public static void main(final String[] args) {
	SpringApplication.run(WebApplication.class, args);
    }

}
