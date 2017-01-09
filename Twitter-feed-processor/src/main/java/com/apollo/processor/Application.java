package com.apollo.processor;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@EnableEurekaClient
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@RequestMapping(value = "/")
	public List<String> available(HttpServletRequest request) {

		System.out.println(request.getRequestURI());
		System.out.println(request.getRequestURL());
		List<String> movies = new ArrayList<>();
		movies.add("Kubo and 2 Strings");
		movies.add("Conjuring");
		return movies;
	}

}
