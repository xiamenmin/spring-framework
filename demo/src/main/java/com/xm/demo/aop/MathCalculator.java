package com.xm.demo.aop;

import org.springframework.beans.factory.DisposableBean;

public class MathCalculator implements DisposableBean {
	public MathCalculator() {
		System.out.println("111");
	}

	public int div(int i, int j) {
		System.out.printf("方法：MathCalculator.div(%d,%d)\n", i, j);
		return i / j;
	}

	public void init(){
		System.out.println(" ... init...");
	}

	@Override
	public void destroy(){
		System.out.println(" ... destroy...");
	}

	public void destroyXml(){
		System.out.println(" ... destroy_xml...");
	}

}