package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class LoginClass {
	 private List<Member> members=new ArrayList<>();

	 public LoginClass() {
		 members.add(new Member("Admin", "admin", "admin", 30, "Gyung-gi", "0101111"));
		 members.add(new Member("YUN", "yun", "yun", 20, "Seoul", "0101112"));
	 }
	 
	 public Member findById(String id) {
		 for(Member m:members) {
			 if(m.getId().equals(id)) {
				 return m;
			 }
		 }
		 return null;
	 }
	 
	 public boolean login(String id, String pwd) {
		boolean idFound=false;
		for(Member m:members) {
			if(m.getId().equals(id)) {
				if(m.getPassword().equals(pwd)) {
					idFound=true;
					return true;
				}
				else {
					idFound=true;
					System.out.println("비밀번호가 틀렸습니다.");
				}
			}
		}
		
		if(!idFound) {
			System.out.println("존재하지 않는 아이디 입니다.");
		}
		
		return false;
	}
	
	public boolean logout() {
		return true;
	}
}
