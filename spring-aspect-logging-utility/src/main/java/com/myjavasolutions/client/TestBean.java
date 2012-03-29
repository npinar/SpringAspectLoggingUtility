package com.myjavasolutions.client;

import com.myjavasolutions.aspect.Loggable;
import com.myjavasolutions.logging.LogLevel;

public class TestBean {

	@Loggable(LogLevel.DEBUG)
	public double getProductCost(int prodId) {
		if(prodId == 0 || prodId < 0) {
			throw new IllegalArgumentException("product id is not valid");
		}
		return 10.0;
	}
	
	@Loggable(LogLevel.DEBUG)
	public String getEmailId(String userId) {
		return "ugur@pinarfamily.com";
	}
	
	
}
