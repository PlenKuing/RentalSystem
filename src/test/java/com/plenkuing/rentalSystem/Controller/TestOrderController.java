package com.plenkuing.rentalSystem.Controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestOrderController {
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
	
	@Test
	public void testSaveRoom() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/saveOrder")
				.param("roomId", "9").param("hostId", "1")).andReturn();
										
		
	}
}
