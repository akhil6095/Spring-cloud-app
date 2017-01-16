package com.apollo.writer.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class WriterController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/write/{userName}")
    public String writeCount(@PathVariable(value = "userName") final String userName,
	    final HttpServletRequest request) {
	System.out.println(String.format("The request is served by writer app with address : %s:%s for user : %s",
		request.getLocalAddr(), request.getLocalPort(), userName));
	return restTemplate.getForObject("http://button-count-recorder/record/" + userName, String.class);
    }

    @RequestMapping(value = "/")
    public String ping() {
	return "Writer server pinged";
    }

}
