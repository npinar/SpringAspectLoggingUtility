package com.myjavasolutions.logging.util;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myjavasolutions.client.TestBean;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml" })
public class LoggingAspectTest {

	@Autowired
	private TestBean testBean;
	
	@Before
	public void setup() {
	}
	
	@Test
	public void getProductCost() throws Exception {
		testBean.getProductCost(10);
	}
}
