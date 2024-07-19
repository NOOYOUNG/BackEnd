package com.board.main.paging;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class Criteria {

	private int currentPageNo;
	private int recordPerPage;
	private int pageSize;
	private String searchKeyword;
	private String searchType;
	
	public String makeQueryString(int pageNo) {
		UriComponents uriComponents=UriComponentsBuilder.newInstance()
				.queryParam("currentPageNo", pageNo)
				.queryParam("recordsPerPage", recordPerPage)
				.queryParam("pageSize", pageSize)
				.queryParam("searchType", searchType)
				.queryParam("searchKeyword", searchKeyword)
				.build()
				.encode();
		
		return uriComponents.toUriString();
	}
	
	
	@Override
	public String toString() {
		return "Criteria [currentPageNo=" + currentPageNo + ", recordsPerPage=" + recordPerPage + ", pageSize="
				+ pageSize + ", searchKeyword=" + searchKeyword + ", searchType=" + searchType + "]";
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getRecordPerPage() {
		return recordPerPage;
	}

	public void setRecordPerPage(int recordsPerPage) {
		this.recordPerPage = recordPerPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSearchKeyword() {
		return searchKeyword;
	}

	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public Criteria() {
		this.currentPageNo=1;
		this.recordPerPage=10;
		this.pageSize=10;
	}
	
	public int getStartPage() {
		return (currentPageNo-1)*recordPerPage;
	}
}
