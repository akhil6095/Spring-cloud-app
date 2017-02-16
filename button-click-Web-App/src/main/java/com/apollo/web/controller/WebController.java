package com.apollo.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

    private final String VIEW_NAME = "index";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/{userName}")
    public @ResponseBody String available(@PathVariable(value = "userName") final String userName,
	    final HttpServletRequest request) {
	System.out.println(String.format("The request is served by web app with address : %s:%s for user : %s",
		request.getLocalAddr(), request.getLocalPort(), userName));
	return restTemplate.getForObject("http://button-count-writer/write/" + userName, String.class);
    }

    @RequestMapping(value = "/")
    public ModelAndView index() {
	return new ModelAndView(VIEW_NAME);
    }

}
