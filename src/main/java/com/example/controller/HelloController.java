package com.example.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.examle.exception.MyException;

@Controller
public class HelloController {
	
	@RequestMapping("/hello")
	public ModelAndView helloPage(HttpServletRequest request){
		return new ModelAndView("hello");
	}
	
	@RequestMapping("/hi")
	public String hiPage(HttpServletRequest request) throws MyException{
		throw new MyException();
	}
	
	@RequestMapping("/hey")
	public ModelAndView heyPage(HttpServletRequest request) throws Exception{
		throw new Exception();
	}
	
	

}
