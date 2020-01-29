package com.xm.demo.aop;

import com.xm.demo.Person;
import org.springframework.beans.factory.config.SingletonBeanRegistry;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext();
		// 注册
		SingletonBeanRegistry singletonBeanRegistry = context.getBeanFactory();
		// 注册外部单例对象
		singletonBeanRegistry.registerSingleton("userFactory", new Person());
		context.refresh();
		// get
		Person p = context.getBean(Person.class);
		System.out.println(p);
		// close
		context.close();
		// 不实用ioc容器的话，切面是无效的
//		MathCalculator calculator = context.getBean(MathCalculator.class);
//		int div = calculator.div(4, 2);
//		System.out.printf("result：%d", div);
	}
}