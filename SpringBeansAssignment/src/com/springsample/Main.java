package com.springsample;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {  

	@SuppressWarnings("resource")
	public static void main(String[] args) {  

		ApplicationContext beanFactory = new ClassPathXmlApplicationContext("SpringSample.xml");  

		SpringSample myBean = (SpringSample) beanFactory.getBean("SpringSample");  
		myBean.printHello();  
	}  

} 