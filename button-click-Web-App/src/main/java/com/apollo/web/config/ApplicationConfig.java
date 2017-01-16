package com.apollo.web.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;

public class ApplicationConfig {

    @Autowired
    IClientConfig ribbonClientConfig;

    @Bean
    public IPing ribbonPing(final IClientConfig config) {
	return new PingUrl();
    }

    @Bean
    public IRule ribbonRule(final IClientConfig config) {
	return new AvailabilityFilteringRule();
    }

}
