package com.board.main;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import org.springframework.data.domain.Sort;

@Controller
public class boardController {
	
	@Autowired
	private	SimpleBoardRepository sbR;

	@Autowired
	private MemberInfoRepository memberInfoRepository;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(HttpServletRequest request) {
		List<SimpleBoard> result = sbR.findAll(Sort.by(Sort.Direction.DESC, "id"));
		request.setAttribute("boardList", result);
		return "index_rest";
	}
	
//	@RequestMapping(value="/", method=RequestMethod.GET) 
//	public String index(HttpServletRequest request) { 
//		List<SimpleBoard> boardList=sbR.findAll();
//		request.setAttribute("boardList", boardList);
//		System.out.println(boardList);
//		return "index";
//	} 
//	
//	@RequestMapping(value="/addBoard", method=RequestMethod.POST)
//	public String addContext(HttpServletRequest request) {
//		String name=request.getParameter("name");
//		String content=request.getParameter("content");
//		String userId=request.getParameter("userId");
//		String password=request.getParameter("password");
//		
//		SimpleBoard board=SimpleBoard.builder()
//				.name(name)
//				.content(content)
//				.userId(userId)
//				.password(password)
//				.build();
//		sbR.save(board);
//		
//		List<SimpleBoard> boardList=sbR.findAll();
//		request.setAttribute("boardList", boardList);
//		
//		return "index";
//	}
	
	@RequestMapping(value="/logoutREST", method=RequestMethod.GET)
	@ResponseBody
	public String logoutREST(HttpServletRequest request, HttpSession session) {
		session.invalidate();
		return "{\"result\": \"success\"}";
	}
	
	@RequestMapping(value="/loginREST", method=RequestMethod.POST)
	@ResponseBody
	public String loginREST(HttpServletRequest request, HttpSession session) {
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("password");		
		Long findCount = memberInfoRepository.countByNameAndPassword(userName, userPassword);		
		if(findCount <= 0) {
			return "{\"result\": \"fail\"}";
		} else {
			MemberInfo loggedMember=memberInfoRepository.findByName(userName);
			
			session.setAttribute("loginok", loggedMember.getId());
			session.setAttribute("loginName", userName);		
			return "{\"result\": \"success\"}";
		}
	}
	
	@RequestMapping(value="/addREST", method=RequestMethod.POST)
	@ResponseBody
	public String addREST(HttpServletRequest request, HttpSession session) {
		String name=(String)session.getAttribute("loginName");
		String content=request.getParameter("contents");
		String password=(String)session.getAttribute("loginok");
		
		SimpleBoard board=SimpleBoard.builder()
				.name(name)
				.content(content)
				.password(password)
				.build();
		sbR.save(board);
		
		return "OK";
	}

	@RequestMapping(value="/modREST", method=RequestMethod.GET)
	@ResponseBody
	public String modREST(HttpServletRequest request, HttpSession session) {
		String contents = request.getParameter("contents");
		String modPass = request.getParameter("password");
		String modName = request.getParameter("name");
		
		SimpleBoard board=SimpleBoard.builder()
				.name(modName)
				.content(contents)
				.password(modPass)
				.build();
		sbR.save(board);
		
		return "OK";
	}

	@RequestMapping(value="/listREST", method=RequestMethod.GET)
	@ResponseBody
	public String listREST(HttpServletRequest request) {
		List<SimpleBoard> resultList = sbR.findAll(Sort.by(Sort.Direction.DESC, "id"));
		String json = new Gson().toJson(resultList);
		return json;
	}
	
	@RequestMapping(value="/delREST", method=RequestMethod.GET)
	@ResponseBody
	public String delREST(HttpServletRequest request, HttpSession session) {
		String userName = request.getParameter("userName");
		String userPassword = (String)session.getAttribute("loginok");
		Long findCount = sbR.countByNameAndPassword(userName, userPassword);
		if(findCount > 0) {
			sbR.deleteByName(userName);
			return "{\"result\": \"success\"}";
		} else {
			return "{\"result\": \"fail\"}";
		}
	}	
	
//	@RequestMapping(value="/listREST", method=RequestMethod.GET)
//	@ResponseBody
//	public String listREST(HttpServletRequest request) {
//		List<SimpleBoard> boardList=sbR.findAll();
//		String json = new Gson().toJson(boardList);
//		return json;
//	}
//	
//	@RequestMapping(value="/delREST", method=RequestMethod.GET)
//	@ResponseBody
//	public String delREST(HttpServletRequest request) {
//		String id = request.getParameter("id");
//		String password = request.getParameter("password");
//		Long contentsId = Long.parseLong(id);
//		
//		Long findCount=sbR.countByIdAndPassword(contentsId, password);
//		if(findCount<=0) {
//			return "{\"result\": \"fail\"}";
//		}
//		else {
//			sbR.deleteById(contentsId);
//			return "{\"result\": \"success\"}";
//		}
//	}
	
}
