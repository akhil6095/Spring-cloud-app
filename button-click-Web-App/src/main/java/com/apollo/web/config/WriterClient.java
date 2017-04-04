package com.apollo.web.config;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "button-count-writer")
public interface WriterClient {

    @RequestMapping(value = "/write/{userName}", method = RequestMethod.GET)
    public String writeObject(@PathVariable("userName") String userName);

}
