package com.board.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class boardController {
	
	@Autowired
	private	SimpleBoardRepository sbR;
	
	@RequestMapping(value="/", method=RequestMethod.GET) 
	public String index(HttpServletRequest request) { 
		List<SimpleBoard> boardList=sbR.findAll();
		request.setAttribute("boardList", boardList);
		System.out.println(boardList);
		return "index";
	} 
	
	@RequestMapping(value="/addBoard", method=RequestMethod.POST)
	public String addContext(HttpServletRequest request) {
		String name=request.getParameter("name");
		String content=request.getParameter("content");
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		
		SimpleBoard board=SimpleBoard.builder()
				.name(name)
				.content(content)
				.userId(userId)
				.password(password)
				.build();
		sbR.save(board);
		
		List<SimpleBoard> boardList=sbR.findAll();
		request.setAttribute("boardList", boardList);
		
		return "index";
	}
	
	@RequestMapping(value="/addREST", method=RequestMethod.POST)
	@ResponseBody
	public String addREST(HttpServletRequest request) {
		String name=request.getParameter("username");
		String content=request.getParameter("contents");
		String userId=request.getParameter("userId");
		String password=request.getParameter("password");
		
		SimpleBoard board=SimpleBoard.builder()
				.name(name)
				.content(content)
				.userId(userId)
				.password(password)
				.build();
		sbR.save(board);
		
		return "OK";
	}
	
	@RequestMapping(value="/listREST", method=RequestMethod.GET)
	@ResponseBody
	public String listREST(HttpServletRequest request) {
		List<SimpleBoard> boardList=sbR.findAll();
		String json = new Gson().toJson(boardList);
		return json;
	}
	
	@RequestMapping(value="/delREST", method=RequestMethod.GET)
	@ResponseBody
	public String delREST(HttpServletRequest request) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		Long contentsId = Long.parseLong(id);
		
		Long findCount=sbR.countByIdAndPassword(contentsId, password);
		if(findCount<=0) {
			return "{\"result\": \"fail\"}";
		}
		else {
			sbR.deleteById(contentsId);
			return "{\"result\": \"success\"}";
		}
	}
	
}
