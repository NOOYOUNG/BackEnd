package com.board.main.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

import com.board.main.paging.Criteria;
import com.board.main.paging.PaginationInfo;
import com.board.main.domain.CommonDTO;

@Getter
@Setter
public class BoardDTO extends CommonDTO{
	private Long idx;
	private String title;
	private String content;
	private String writer;
	private int viewCnt;
	private String noticeYn;
	private String secretYn;
	
}