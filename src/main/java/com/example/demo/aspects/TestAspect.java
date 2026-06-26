package com.example.demo.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {

	@Pointcut("execution(public void com.example.demo.service.AspectService.testMethod1())")
	public void pointcut1() {
		System.out.println("pointcut 1");
	}



	/*
	 * @Pointcut("execution(public String com.dev.spring.aop.service.InvoiceBusinessService.helloInvoice())"
	 * ) public void p2() {
	 * 
	 * }
	 * 
	 * 
	 * @Pointcut("execution(* com.dev.spring.aop.service.InvoiceBusinessService.testMethodforAroundAdvice())"
	 * ) public void p4() {
	 * 
	 * }
	 */


	@Before("pointcut1()") public void beginTransaction() {
		System.out.println("before pointcut1!"); 
	}

	@After("pointcut1()") public void completeTransaction() {
		System.out.println("after pointcut1!"); 
	}

	@AfterReturning("pointcut1()") public void commitTransaction() {
		System.out.println("after returning pointcut1!"); 
	}

	@AfterThrowing("pointcut1()") public void rollbackTransaction() {
		System.out.println("After throwing pointcut1!"); 
	}



	/*
	 * @AfterReturning(value="p2()", returning = "obj") public void
	 * getAdviceReturnValue(Object obj) {
	 * System.out.println("Returning Value is : "+obj); }
	 * 
	 * @AfterThrowing(value="p1()", throwing = "th") public void
	 * rollbackTransactionGetMessage(Throwable th) {
	 * System.out.println("Transaction rolled back ! Message from method : "+th); }
	 */


	@Around("pointcut1()") public void testAroundAdvice(ProceedingJoinPoint pj) throws
	Throwable {

		System.out.println("Executing Before part of business method");

		pj.proceed(); // this code will call business method

		System.out.println("Executing After part of business method"); 
	}




}
