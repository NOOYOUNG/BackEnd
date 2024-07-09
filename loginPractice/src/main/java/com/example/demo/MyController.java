package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyController {
	public LoginClass lC;
	
	public MyController() {
		this.lC=new LoginClass();
	}
	
	@RequestMapping(value="/logIn", method = RequestMethod.GET)
	public String logIn(HttpServletRequest request) {
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		if(lC.login(id, pwd)==true) {
			Member loggedMember=lC.findById(id);
			
			request.setAttribute("currentId", loggedMember.getId());
			request.setAttribute("currentName", loggedMember.getName());
			request.setAttribute("currentAge", loggedMember.getAge());
			request.setAttribute("currentAddress", loggedMember.getAddress());
			request.setAttribute("currentPhone", loggedMember.getPhone());			
			
			return "loginSuccess";
		}
		else {
			return "loginFail";
		}
		
//		for(Member m:members) {
//			if(m.getId().equals(id)) {
//				if(m.getPassword().equals(pwd)) {
//					
//					return "loginSuccess";
//				}
//				else {
//					System.out.println("존재하지 않는 비밀번호 입니다.");
//					return "Index";
//				}
//			}
//		}
//		
//		System.out.println("존재하지 않는 아이디 입니다,");
//		return "loginFail";
	}
	
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		lC.logout();
		return "logout";
	}
}
