package com.board.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.board.main.domain.BoardDTO;
import com.board.main.domain.CommonDTO;
import com.board.main.paging.Criteria;
import com.board.main.paging.PaginationInfo;
import com.board.main.service.BoardService;
import com.board.main.util.UiUtils;
import com.board.main.constant.Method;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class BoradController extends UiUtils {
	
	@Autowired
	private BoardService boardService;	
	
    @Autowired
    private HttpServletRequest request;

	
	@GetMapping(value="/board/write.do")
	public String openBoardWrite(@RequestParam(value="idx", required=false) Long idx, Model model) {
		if(idx==null) {
			model.addAttribute("board", new BoardDTO());
		} else {
			BoardDTO board=boardService.getBoardDetail(idx);
			if(board==null) {
				return showMessageWithRedirect("없는 게시글이거나 이미 삭제된 게시글입니다.", "/board/list.do", Method.GET, null, model);
			}
			model.addAttribute("board", board);
		}
		
		return "write";
	}
	
	
	@PostMapping(value="/board/register.do")
	public String registerBoard(final BoardDTO params, Model model) {
		try {
			boolean isRegistered=boardService.registerBoard(params);
			
			if(isRegistered==false) {
				return showMessageWithRedirect("게시글 등록에 실패하였습니다.", "/board/list.do", Method.GET, null, model);
			}
		} catch(DataAccessException e) {
			return showMessageWithRedirect("DB 처리 과정에 문제가 발생했습니다.", "/board/list.do", Method.GET, null, model);
		} catch(Exception e) {
			return showMessageWithRedirect("시스템에 문제가 발생했습니다.", "/board/list.do", Method.GET, null, model);
		}
		return "redirect:/board/list.do";
	}
	
	
	@GetMapping(value="/board/list.do")
	public String openBoardList(@ModelAttribute("params") BoardDTO params, Model model) {
		List<BoardDTO> boardList=boardService.getBoardList(params);
		model.addAttribute("boardList", boardList);
		
		return "list";
	}


	@GetMapping(value="/board/view.do")
	public String openBoardDetail(@RequestParam(value="idx", required=false) Long idx, Model model) {
		if(idx==null) {
			System.out.println("올바르지 않은 접근");
			return "redirect:/board/list.do";
		}
		
		BoardDTO board=boardService.getBoardDetail(idx);
		if(board==null || "Y".equals(board.getDeleteYn())) {
			System.out.println("없는 게시글입니다.");
			return "redirect:/board/list.do";
		}
		model.addAttribute("board", board);
		
		return "view";
	}
	
	
	@PostMapping(value="/board/delete.do")
	public String deleteBoard(@RequestParam(value="idx", required=false) Long idx, Model model) {
		if(idx==null) {
			return showMessageWithRedirect("게시글 삭제에 실패하였습니다.", "/board/list.do", Method.GET, null, model);
		}
		System.out.println("11");
		try {
			boolean isDeleted=boardService.deleteBoard(idx);
			if(isDeleted==false) {
				return showMessageWithRedirect("DB 처리 과정에 문제가 발생했습니다.", "/board/list.do", Method.GET, null, model);
			}
		} catch(DataAccessException e) {
			return showMessageWithRedirect("게시글 등록에 실패하였습니다.", "/board/list.do", Method.GET, null, model);
		} catch(Exception e) {
			return showMessageWithRedirect("시스템에 문제가 발생했습니다.", "/board/list.do", Method.GET, null, model);
		}
		
		return "redirect:/board/list.do";
		//return showMessageWithRedirect("게시글 삭제가 완료되었습니다.", "/board/list.do", Method.GET, null, model);
	}
	


}
