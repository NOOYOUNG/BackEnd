package com.board.main;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import com.board.main.domain.BoardDTO;
import com.board.main.mapper.BoardMapper;
import com.board.main.paging.Criteria;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootTest
class MapperTests {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testOfInsert() {
		BoardDTO params=new BoardDTO();
		params.setTitle("1번 게시글 제목");
		params.setContent("1번 게시글 내용");
		params.setWriter("테스터");
		
		int result=boardMapper.insertBoard(params);
		System.out.println("결과는"+result+"입니다");
	}
	
	@Test
	public void testOfSelectDetail() {
		System.out.println("11");
		BoardDTO board= boardMapper.selectBoardDetail((long)1);
		System.out.println("22");
		try {
			String boardJson=new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
			System.out.println("=============");
			System.out.println(boardJson);
			System.out.println("=============");
		} catch(JsonProcessingException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testOfUpdate() {
		BoardDTO params=new BoardDTO();
		params.setTitle("4번 게시글 제목");
		params.setContent("4번 게시글 내용");
		params.setWriter("테스터");
		params.setIdx((long)4);
		
		int result=boardMapper.updateBoard(params);
		if(result==1) {
			BoardDTO board=boardMapper.selectBoardDetail((long)4);
			try {
				String boardJson=new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
				
				System.out.println("============");
				System.out.println(boardJson);
				System.out.println("============");
			} catch(JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testOfDelete() {
		int result=boardMapper.deleteBoard((long)4);
		System.out.println("11");
		if(result==1) { // result는 0 아니면 1
			BoardDTO board=boardMapper.selectBoardDetail((long)4);
			System.out.println("22");
			try {
				String boardJson=new ObjectMapper().registerModule(new JavaTimeModule()).writeValueAsString(board);
				
				System.out.println("=================");
				System.out.println(boardJson);
				System.out.println("==================");
			} catch(JsonProcessingException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Test
	public void testSelectList() {
		BoardDTO params=new BoardDTO();
		int boardTotalCount=boardMapper.selectBoardTotalCount(params);
		if(boardTotalCount>0) {
			List<BoardDTO> boardList=boardMapper.selectBoardList(params);
			if(CollectionUtils.isEmpty(boardList)==false) {
				for(BoardDTO board : boardList) {
					System.out.println("===========");
					System.out.println(board.getTitle());
					System.out.println(board.getContent());
					System.out.println(board.getWriter());
					System.out.println("===========");
				}
			}
		}
	}
}
