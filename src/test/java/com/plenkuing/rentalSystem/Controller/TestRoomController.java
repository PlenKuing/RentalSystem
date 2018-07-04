package com.plenkuing.rentalSystem.Controller;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.github.pagehelper.PageInfo;
import com.plenkuing.rentalSystem.entity.Room;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestRoomController {
	@Autowired
	private WebApplicationContext context;
	private MockMvc mvc;
	@Before
	public void setUp() throws Exception {
		mvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	

	@Test
	public void testRoomInfo() throws Exception {	
		//模拟分页请求 ，并返回结果
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/roomInfo")
				.param("pageNum", "2"))
				.andReturn();		
		MockHttpServletRequest request = result.getRequest();
		@SuppressWarnings("unchecked")
		PageInfo<Room> pi= (PageInfo<Room>) request.getAttribute("pageInfo");
		System.out.println("当前页数："+pi.getPageNum());
		System.out.println("总页码："+pi.getPages());
		System.out.println("总记录数："+pi.getTotal());
		System.out.println("页面需要显示的连续页码数："+pi.getNavigatePages());
		
		int[] nums = pi.getNavigatepageNums();
		for (int  i : nums) {
			System.out.println(i+" ");
		}
		List<Room> rooms = pi.getList();
		for (Room room : rooms) {
			System.out.println(room);
		}		
	}
	
	@Test
	public void testHostRoomInfo() throws Exception {
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get("/hostRoom/2")).andReturn();
		MockHttpServletRequest request = result.getRequest();
		@SuppressWarnings("unchecked")
		PageInfo<Room> pageInfo  = (PageInfo<Room>) request.getAttribute("pageInfo");
		List<Room> rooms = pageInfo.getList();
		for (Room room : rooms) {
			System.out.println(room);
		}
		
		
		
	}

	
	
	
}
