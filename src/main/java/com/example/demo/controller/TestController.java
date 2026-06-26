package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.AspectService;
import com.example.demo.service.RetryService;

@RestController
@RequestMapping(value="/api/test")
public class TestController {

	@Autowired
	private AspectService testService;
	
	@Autowired
	private RetryService retryService;
	
	@GetMapping(value="/aspect")
	public String testAspect() {
		testService.testMethod1();
		testService.testMethod2();
		testService.testMethod3();
		return "success";
	}
	
	@GetMapping(value="/retry")
	public String testRetry() throws Exception {
		String returnedString = retryService.retryServiceWithRecovery("Test String");
		System.out.println("returned string is "+ returnedString);
		//throw new Exception();
		return returnedString;
	}
	
	@GetMapping(value="/circuit-breaker")
	public String testCircuitBreaker() {
		testService.testMethod4();
		return "success";
	}
}
