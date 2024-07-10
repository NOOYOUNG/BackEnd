package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LoginClassMemo {
	 private MemoRepository memoRepository;
	 
	 public Memo findById(String userId) {
		 Memo opMemo=memoRepository.findByUserId(userId);
		 return opMemo;
	 }
	 
	 public boolean login(MemoRepository memoRepository, String userId, String pwd) {
		Long findCount=memoRepository.countByUserIdAndPassword(userId, pwd);
		if(findCount<=0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public boolean logout() {
		return true;
	}
	
}
