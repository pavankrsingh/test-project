package com.example.demo.service;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;

public interface RetryService {

	@Retryable(value = RuntimeException.class, backoff = @Backoff(delay = 1000), maxAttempts = 10)
	@Async
	public String retryServiceWithRecovery(String sql) throws RuntimeException;
	
	@Recover
	public String recovery(RuntimeException exc, String sql);

	String retryService(String sql);
	
}
