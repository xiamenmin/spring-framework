package com.xm.demo.ioc;

import com.xm.demo.Person;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainIocTest {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainIocConfiguration.class);
		Person p = context.getBean(Person.class);
		System.out.println(p);
	}

}
