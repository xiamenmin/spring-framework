package com.xm.demo.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainAopTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		// 不实用ioc容器的话，切面是无效的
		MathCalculator calculator = context.getBean(MathCalculator.class);
		int div = calculator.div(4, 2);
		System.out.printf("result：%d", div);
	}
}