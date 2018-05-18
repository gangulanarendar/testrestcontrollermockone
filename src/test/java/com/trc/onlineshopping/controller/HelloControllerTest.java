package com.trc.onlineshopping.controller;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.trc.onlineshopping.domain.Hello;

@RunWith(SpringJUnit4ClassRunner.class)
public class HelloControllerTest {
    
	private MockMvc mockMvc;

	@Mock
	private HelloService helloService;

	@InjectMocks
	HelloController helloController;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(helloController).build();
	}

	// @Test
	public void testHelloWorld() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/hello"))
				// .andDo(MockMvcResultHandlers.print());
				.andExpect(MockMvcResultMatchers.status().isOk())
				// .andExpect(MockMvcResultMatchers.model().equals(new String("")))
				.andExpect(MockMvcResultMatchers.content().string("hello")).andDo(MockMvcResultHandlers.print());

	}

	// @Test
	public void testJsonResponse() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/getjson").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("msg")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.value", Matchers.is("world")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(2)))
			//	.andDo(MockMvcResultHandlers.print());
		;
	}

	//@Test
	public void testJsonAllResponse() throws Exception {
		List<Hello> al = new ArrayList<Hello>();
		al.add(new Hello("msg", "first"));
		al.add(new Hello("msg", "second"));
		Mockito.when(helloService.getAllJson()).thenReturn(al);
		mockMvc.perform(MockMvcRequestBuilders.get("/getAlljson").accept(MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().is(200))
				// .andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("msg")))
				.andExpect(MockMvcResultMatchers.jsonPath("$[1].value", Matchers.is("second")))
				.andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(2)))
				//.andDo(MockMvcResultHandlers.print());
		;
		Mockito.verify(helloService,Mockito.times(1)).getAllJson();

	}

	@Test
	public void testpostJsonAllResponse() throws Exception {
		
		
		String jsonString="{\"message\": \"msg\",\"value\": \"msg\"}";
		
		
		Hello h=new Hello("msg", "second");
		Hello actual=new Hello("msgupdated", "second");
	 	//Mockito.when(helloService.postJson(h)).thenReturn(jsonString);
		mockMvc.perform(MockMvcRequestBuilders.post("/postjson")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonString)
				.accept(MediaType.APPLICATION_JSON))		
				.andExpect(MockMvcResultMatchers.status().is(200))
				.andExpect(MockMvcResultMatchers.jsonPath("$.message", Matchers.is("msg")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.value", Matchers.is("msg")))
				.andExpect(MockMvcResultMatchers.jsonPath("$.*", Matchers.hasSize(2)))
				.andDo(MockMvcResultHandlers.print());
		;
	//	Mockito.verify(helloService,Mockito.times(1)).postJson(h);

	}
}
