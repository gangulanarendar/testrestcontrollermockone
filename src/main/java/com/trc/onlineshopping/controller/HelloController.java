package com.trc.onlineshopping.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.trc.onlineshopping.domain.Hello;

@RestController
public class HelloController {
	
	
	
	@Autowired
	@Qualifier("helloService")
	private HelloService helloService;
	
	public HelloController(HelloService helloService) {
		 this.helloService= helloService;
	}
	
	
	//@RequestMapping(value="/check")
	@RequestMapping("/hello")
	public String sayHello()
	{
		System.out.println("sayHello  called");
		return "hello";
	}
	
	@GetMapping(value="/getjson",produces = "application/json")
	public Hello getJson()
	{
		return new Hello("msg","world");
	}
	
	
	@GetMapping(value="/getAlljson",produces = "application/json")
	public List<Hello> getAllJson()
	{
		

		/*List<Hello> al=new ArrayList<Hello>();
		al.add(new Hello("msg","first"));
		al.add(new Hello("msg","second"));
		
		return al;*/
		//System.out.println("Bui "+helloService.getAllJson());
		return helloService.getAllJson();
	}
	
	
	@PostMapping(value="/postjson",produces = "application/json",consumes="application/json")
	public Hello postJson(@RequestBody  Hello hello)
	{
		return hello;
		//hello.setMessage(hello.getMessage()+"updated");
	//	return helloService.postJson(hello);
	}
	
	
    
}
