package com.ebore.bank.config;

import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;



@Configuration
public class BankConfig {
	@Bean
	public RestTemplate restTemplateBean() {
		return new RestTemplate();
	}
}
