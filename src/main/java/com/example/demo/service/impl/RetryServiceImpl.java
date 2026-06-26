package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.service.RetryService;

@Service
public class RetryServiceImpl implements RetryService{
	
	@Override
	public String retryService(String sql){
		System.out.println("In retry service with string " + sql);
		return sql;
	}

	@Override
	public String retryServiceWithRecovery(String sql) throws RuntimeException {
		System.out.println("In retry service with recovery with string " + sql);
		throw new RuntimeException("demo exception");
		
	}

	@Override
	public String recovery(RuntimeException exc, String sql) {
		System.out.println("In recover method with error message " + exc.getLocalizedMessage() + " and string " + sql);
		return sql;
	}

}
