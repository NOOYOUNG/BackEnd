package com.example.demo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.data.domain.Sort;

@Controller
public class MyControllerMemo {
	@Autowired // 종속성
	private MemoRepository memoRepository;
	
	@Autowired
	private BookDao bookDao;
	
	LoginClassMemo lC=new LoginClassMemo();
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(HttpServletRequest request) {
		return "index";
	}
	
	@RequestMapping(value="/joins", method=RequestMethod.POST)
	public String joinStart(HttpServletRequest request) {
		String id=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		String name=request.getParameter("name");
		String Age=request.getParameter("age");
		int age=Integer.parseInt(Age);
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		
		Memo memo=Memo.builder()
				.userId(id)
    			.password(pwd)
    			.name(name)
                .age(age)
                .address(address)
                .phone(phone)
    			.build();
    	memoRepository.save(memo);
    	
    	return "complete";
	}

	@RequestMapping(value="/logIn", method = RequestMethod.POST)
	public String logIn(HttpServletRequest request, HttpSession session) {
		String userid=request.getParameter("id");
		String pwd=request.getParameter("pwd");
		
		if(lC.login(memoRepository, userid, pwd)==true) {
			Memo loggedMemo = memoRepository.findByUserId(userid);
			
	        request.setAttribute("currentuserId", loggedMemo.getUserId());
	        request.setAttribute("currentName", loggedMemo.getName());
	        request.setAttribute("currentAge", loggedMemo.getAge());
	        request.setAttribute("currentAddress", loggedMemo.getAddress());
	        request.setAttribute("currentPhone", loggedMemo.getPhone());
	        
	        session.setAttribute("loginok", userid);
			
			return "loginSuccess";
		}
		else {
			return "loginFail";
		}
	}
	
	@RequestMapping(value="/loginok", method=RequestMethod.GET)
	public String loginOk(HttpServletRequest request, HttpSession session) {
		String id=(String)session.getAttribute("loginok");
		if(id==null) {
			return "redirect:/";
		}
		
		Memo resultMemo=memoRepository.findByUserId(id);
		if(resultMemo==null) {
			return "redirect:/";
		}
		
		request.setAttribute("cuurenduserId", id);
		request.setAttribute("currentName", resultMemo.getName());
		request.setAttribute("currentAge", resultMemo.getAge());
		request.setAttribute("currentAddress", resultMemo.getAddress());
		request.setAttribute("currentPhone", resultMemo.getPhone());
		
		return "loginSuccess"; 
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request, HttpSession session) {
		session.setAttribute("loginok", null);
		lC.logout();
		return "logout";
	}
	
	@RequestMapping(value="/updatePage", method = RequestMethod.GET)
	public String updatePage(HttpServletRequest request) {
		String userid=request.getParameter("userId");
		
		Memo loggedMemo=memoRepository.findByUserId(userid);
		request.setAttribute("currentuserId", loggedMemo.getUserId());
	    request.setAttribute("currentName", loggedMemo.getName());
	    request.setAttribute("currentAge", loggedMemo.getAge());
	    request.setAttribute("currentAddress", loggedMemo.getAddress());
	    request.setAttribute("currentPhone", loggedMemo.getPhone());
		
		return "updateMember";
	}
	
	@RequestMapping(value="/updateMember", method=RequestMethod.GET)
	public String updateMember(HttpServletRequest request) {
		String userid=request.getParameter("userId");
		String modname=request.getParameter("modName");
		String modAge=request.getParameter("modAge");
		int modage=0;
		if(modAge!=null && !modAge.isEmpty()) {
			modage=Integer.parseInt(modAge);
		}
		String modaddress=request.getParameter("modAddress");
		String modphone=request.getParameter("modPhone");
		
		Memo loggedMemo=memoRepository.findByUserId(userid);

		Memo memo=Memo.builder()
				.id(loggedMemo.getId())
				.userId(loggedMemo.getUserId())
				.name(modname)
	            .age(modage)
	            .address(modaddress)
	            .phone(modphone)
	            .password(loggedMemo.getPassword())
	    		.build();
		memoRepository.save(memo);
		
		request.setAttribute("currentuserId", loggedMemo.getUserId());
	    request.setAttribute("currentName", loggedMemo.getName());
	    request.setAttribute("currentAge", loggedMemo.getAge());
	    request.setAttribute("currentAddress", loggedMemo.getAddress());
	    request.setAttribute("currentPhone", loggedMemo.getPhone());
		
		return "loginSuccess";
	}
	
	@RequestMapping(value="/findPage", method = RequestMethod.GET) //index.html에 있음
	public String findPage(HttpServletRequest request) {
		return "findPassword";
	}
	
	
	@RequestMapping(value="/findPassword", method=RequestMethod.POST)
	public String findPassword(HttpServletRequest request) {
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		
		Memo loggedMemo=memoRepository.findByNameAndPhone(name, phone);
		System.out.println(loggedMemo);
		
		if(loggedMemo!=null) {
			request.setAttribute("currentId", loggedMemo.getUserId());
			return "rePassword";	
		}
		else {
			System.out.println("존재하지 않는 회원입니다.");
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/resetPassword", method=RequestMethod.POST)
	public String resetPassword(HttpServletRequest request) {
		String userId=request.getParameter("userId");
		String repwd=request.getParameter("pwd");
		
		Memo loggedMemo=memoRepository.findByUserId(userId);
		System.out.println(repwd);
		
		/*
		 * Memo memo=Memo.builder() .id(loggedMemo.getId())
		 * .userId(loggedMemo.getUserId()) .name(loggedMemo.getName())
		 * .age(loggedMemo.getAge()) .address(loggedMemo.getAddress())
		 * .phone(loggedMemo.getPhone()) .password(repwd) .build();
		 */
		
		loggedMemo.setPassword(repwd);
		memoRepository.save(loggedMemo);
		
		return "redirect:/";
	}
	
	@RequestMapping(value="/deleteMember", method=RequestMethod.GET)
	public String deleteMember(HttpServletRequest request) {
		String userid=request.getParameter("userId"); // loginSuccess의 hidden userId
		String pwd=request.getParameter("pwd");
		
		Memo loggedMemo=memoRepository.findByUserId(userid);
		//System.out.println(loggedMemo);
		
		if(lC.login(memoRepository, loggedMemo.getUserId(), loggedMemo.getPassword())==true) {
			memoRepository.deleteByUserId(loggedMemo.getUserId());
			
			return "deleteMember";	
		}
		else {
			return "loginSuccess";
		}
	}
	
	
	@RequestMapping(value="/addBook", method=RequestMethod.GET)
	public String addBook(HttpServletRequest request) {
		return "addBook";
	}
	
	@RequestMapping(value="/insertbook", method=RequestMethod.GET)
	public String insertBook(HttpServletRequest request) {
		String bookName=request.getParameter("bookname");
		String isbn=request.getParameter("isbn");
		String author=request.getParameter("author");
		String publisher=request.getParameter("publisher");
		String publishdate=request.getParameter("publishdate");
		
		DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate publishDate=LocalDate.parse(publishdate, formatter);
		
		BookInfo book=BookInfo.builder()
				.bookName(bookName)
				.isbn(isbn)
				.author(author)
				.publisher(publisher)
				.publishDate(publishDate)
				.build();
		bookDao.save(book);
		
		return "loginSuccess";
	}
	
	@RequestMapping(value="/readBookPage", method=RequestMethod.GET)
	public String readBookPage(HttpServletRequest request) {
		List<BookInfo> bookList=bookDao.findAll(Sort.by(Sort.Direction.DESC, "publishDate")); //전체 리스트의 정보를 찾아서 넘겨줌
		
		request.setAttribute("bookList", bookList);
		
		return "readBookList";
	}
	
	@RequestMapping(value="/deleteBook", method=RequestMethod.GET)
	public String deleteBook(HttpServletRequest request) {
			String delId=request.getParameter("id");
			Long id=Long.parseLong(delId);
			bookDao.deleteById(id);
			
			List<BookInfo> bookList=bookDao.findAll(Sort.by(Sort.Direction.DESC, "publishDate")); //전체 리스트의 정보를 찾아서 넘겨줌
			request.setAttribute("bookList", bookList);
			
			return "readBookList"; 
	}
	
	@RequestMapping(value="/searchBook", method=RequestMethod.GET)
	public String searchBookPage(HttpServletRequest request) {
		String searchText=request.getParameter("searchText");
		
		List<BookInfo> bookList=bookDao.findByBookNameContains(searchText); //전체 리스트의 정보를 찾아서 넘겨줌
		//containing==LIKE
		
		request.setAttribute("bookList", bookList);
		
		return "readBookList";
	}
	
	@RequestMapping(value="/MyPage", method=RequestMethod.GET)
	public String readBookList(HttpServletRequest request) {
		return "loginSuccess";
	}

	


	
}