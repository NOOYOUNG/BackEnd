package com.example.demo;

import org.springframework.aop.target.HotSwappableTargetSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
//IndexFE.html 적용
@Controller
public class MyController1 {

	@RequestMapping(value="/calAdd", method=RequestMethod.GET)
	public String calcAdd(HttpServletRequest request) {
		Calculator calc=new Calculator();
		request.setAttribute("resultValue", calc.add(request.getParameter("a"), request.getParameter("b")));
		return "Result";		
	}
	
	@RequestMapping(value="/calSub", method=RequestMethod.GET)
	public String calcSub(HttpServletRequest request) {
		Calculator calc=new Calculator();
		request.setAttribute("resultValue", calc.sub(request.getParameter("a"), request.getParameter("b")));
		return "Result";
	}
	
	@RequestMapping(value="/calMul", method=RequestMethod.GET)
	public String calcMul(HttpServletRequest request) {
		Calculator calc=new Calculator();
		request.setAttribute("resultValue", calc.mul(request.getParameter("a"), request.getParameter("b")));
		return "Result";		
	}
	
	@RequestMapping(value="/calDiv", method=RequestMethod.GET)
	public String calcDiv(HttpServletRequest request) {
		Calculator calc=new Calculator();
		request.setAttribute("resultValue", calc.div(request.getParameter("a"), request.getParameter("b")));
		return "Result";
	}
	
	@RequestMapping(value="/calcall", method=RequestMethod.GET)
	public String calcAll(HttpServletRequest request) {
		Calculator calc=new Calculator();
		request.setAttribute("resultValue", calc.all(request.getParameter("a"), request.getParameter("b"), request.getParameter("op")));
		return "Result";
	}
}
