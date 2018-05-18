package com.trc.onlineshopping.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.trc.onlineshopping.domain.Hello;
@Service
public class HelloService {
	
	public List<Hello> getAllJson()
	{	
		
		List<Hello> al=new ArrayList<Hello>();
		al.add(new Hello("msg","first"));
		al.add(new Hello("msg","second"));		
		return al;
		
	}

	
	public Hello postJson(Hello hello)
	{
		
		//hello.setMessage(hello.getMessage()+"updated");
		return hello;
	}
}
