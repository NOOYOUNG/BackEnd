package com.example.demo;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import jakarta.servlet.http.HttpServletRequest;


@Controller
public class MyController {
	@RequestMapping(value="/hi", method=RequestMethod.GET)
	@ResponseBody
	public String goHi(HttpServletRequest request) {
		System.out.println("hi");
		return "Hello spring";
	}
	
	@RequestMapping(value="/poly", method=RequestMethod.GET)
	@ResponseBody
	public String goPoly(HttpServletRequest request) {
		String inputdata = request.getParameter("id");
		String inputpass=request.getParameter("pass");
		return "Hello polytech: "+inputdata+", password: "+inputpass;
	}
	
	MyCalculator calc=new MyCalculator();
	
	@RequestMapping(value="/calAdd", method=RequestMethod.GET)
	@ResponseBody
	public String calAdd(HttpServletRequest request) {
		String stringa = request.getParameter("a");
		String stringb = request.getParameter("b");
		
		int inta=Integer.parseInt(stringa);
		int intb=Integer.parseInt(stringb);

		String Result=calc.calAdd(inta, intb, new CalAdd());
		
		return Result;
	}
	
	@RequestMapping(value="/calSub", method=RequestMethod.GET)
	@ResponseBody
	public String calSub(HttpServletRequest request) {
		String stringa = request.getParameter("a");
		String stringb = request.getParameter("b");
		
		int inta=Integer.parseInt(stringa);
		int intb=Integer.parseInt(stringb);

		String Result = calc.calSub(inta, intb, new CalSub());
		
		return Result;
	}
	
	@RequestMapping(value="/calMul", method=RequestMethod.GET)
	@ResponseBody
	public String calMul(HttpServletRequest request) {
		String stringa = request.getParameter("a");
		String stringb = request.getParameter("b");
		
		int inta=Integer.parseInt(stringa);
		int intb=Integer.parseInt(stringb);

		String Result=calc.calMul(inta, intb, new CalMul());
		
		return Result;
	}
	
	@RequestMapping(value="/calDiv", method=RequestMethod.GET)
	@ResponseBody
	public String calDiv(HttpServletRequest request) {
		String stringa = request.getParameter("a");
		String stringb = request.getParameter("b");
		
		int inta=Integer.parseInt(stringa);
		int intb=Integer.parseInt(stringb);
		
		String Result=calc.calDiv(inta, intb, new CalDiv());
		
		return Result;
	}
	
	@RequestMapping(value="/calTotal", method=RequestMethod.GET)
	@ResponseBody
	public String calTotal(HttpServletRequest request) {
		String stringa = request.getParameter("a");
		String stringb = request.getParameter("b");
		
		int inta=Integer.parseInt(stringa);
		int intb=Integer.parseInt(stringb);
		
		String resultA=calc.calAdd(inta, intb, new CalAdd());
		String resultB=calc.calSub(inta, intb, new CalSub());
		String resultC=calc.calMul(inta, intb, new CalMul());
		String resultD=calc.calDiv(inta, intb, new CalDiv());
		
		return resultA+"<br>"+resultB+"<br>"+resultC+"<br>"+resultD;
	}
	
	/*
	@RequestMapping(value="/calAdd", method=RequestMethod.GET)
	@ResponseBody
	public String calAdd(HttpServletRequest request) {
		String stringa = request.getParameter("a");
		String stringb = request.getParameter("b");
		
		int inta=Integer.parseInt(stringa);
		int intb=Integer.parseInt(stringb);
		return stringa + " + " + stringb + " = "+ (inta+intb);
	}
	
	@RequestMapping(value="/calSub", method=RequestMethod.GET)
	@ResponseBody
	public String calSub(HttpServletRequest request) {
		String stringa = request.getParameter("a");
		String stringb = request.getParameter("b");
		
		int inta=Integer.parseInt(stringa);
		int intb=Integer.parseInt(stringb);
		return stringa + " - " + stringb + " = "+ (inta-intb);
	}
	
	@RequestMapping(value="/calMul", method=RequestMethod.GET)
	@ResponseBody
	public String calMul(HttpServletRequest request) {
		String stringa = request.getParameter("a");
		String stringb = request.getParameter("b");
		
		int inta=Integer.parseInt(stringa);
		int intb=Integer.parseInt(stringb);
		return stringa + " * " + stringb + " = "+ (inta*intb);
	}
	
	@RequestMapping(value="/calDiv", method=RequestMethod.GET)
	@ResponseBody
	public String calDiv(HttpServletRequest request) {
		String stringa = request.getParameter("a");
		String stringb = request.getParameter("b");
		
		int inta=Integer.parseInt(stringa);
		int intb=Integer.parseInt(stringb);
		return stringa + " / " + stringb + " = "+ (inta/intb);
	}
	*/
}
