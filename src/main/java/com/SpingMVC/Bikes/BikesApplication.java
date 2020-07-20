package com.SpingMVC.Bikes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class BikesApplication {
	
	private static final Logger log = LoggerFactory.getLogger(BikesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BikesApplication.class, args);
	}
	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			//Quote quote = restTemplate.getForObject(
			//		"https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			ResponseEntity<Quote> quote = restTemplate.exchange("https://gturnquist-quoters.cfapps.io/api/random", HttpMethod.GET, null , Quote.class);
			log.info(quote.toString());
			System.out.println(quote.toString());
		};
	}

}
