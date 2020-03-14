package com.xm.demo.ioc;

import com.xm.demo.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MainIocConfiguration {

	@Bean
	public Person person(){
		return new Person("张三",14);
	}
}
