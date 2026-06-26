package com.example.demo.service.impl;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.service.AspectService;

@Service
public class AspectServiceImpl implements AspectService{

	@Override
	@CircuitBreaker(include = { Exception.class }, openTimeout = 10000, resetTimeout = 30000, maxAttempts = 2)
	public void testMethod1() {
		System.out.println("testMethod1");
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<String> response = template.exchange("http://localhost:8081/api/test/retry", HttpMethod.GET, request, String.class);
		
		System.out.println("response is " + response);
	}
	
	@Override
	public void testMethod2() {
		System.out.println("testMethod2");
	}
	
	@Override
	public void testMethod3() {
		System.out.println("testMethod3");
	}
	
	@Override
	@CircuitBreaker(include = { Exception.class }, openTimeout = 10000, resetTimeout = 30000, maxAttempts = 2)
	public void testMethod4() {
		System.out.println("testMethod4");
		RestTemplate template = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> request = new HttpEntity<>(headers);
		ResponseEntity<String> response = template.exchange("http://localhost:8081/api/test/retry", HttpMethod.GET, request, String.class);
		
		System.out.println("response is " + response);
	}
}
