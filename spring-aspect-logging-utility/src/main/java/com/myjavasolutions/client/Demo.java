package com.myjavasolutions.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		TestBean testBean = (TestBean) applicationContext.getBean("testBean");
		
		try {
			testBean.getProductCost(0);
		} catch (Exception e) {
			//don't do anything
		}
		
		testBean.getProductCost(10);
		testBean.getEmailId("npinar");

	}

}
