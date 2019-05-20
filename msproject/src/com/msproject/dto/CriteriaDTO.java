package com.msproject.dto;

public class CriteriaDTO {
	int page;				//페이지 번호
	int perPageNum;			//한 페이지에 보여줄 게시글 수
	String keyword;			//검색 키워드
	String search_option;	//검색 타입
	String sort_type;		//정렬 타입
	
	public CriteriaDTO() {
		this.page = 1;
		this.perPageNum = 10;
	}

	public CriteriaDTO(int page, int perPageNum, String keyword, String search_option, String sort_type) {
		super();
		this.page = page;
		this.perPageNum = perPageNum;
		this.keyword = keyword;
		this.search_option = search_option;
		this.sort_type = sort_type;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		if(page<=0) {
			this.page = 1;
			return;
		}
		this.page = page;
	}
	
	// 조회 시작 row 취득하는 메서드
	public int getPageStart() {
		return (((this.page -1) * perPageNum)+1);
	}
	
	// 조회 마지막 row 취득하는 메서드
	public int getPerPageNum() {
		return this.page * perPageNum;
	}

	public void setPerPageNum(int perPageNum) {
		this.perPageNum = perPageNum;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSearch_option() {
		return search_option;
	}

	public void setSearch_option(String search_option) {
		this.search_option = search_option;
	}

	public String getSort_type() {
		return sort_type;
	}

	public void setSort_type(String sort_type) {
		this.sort_type = sort_type;
	}

	@Override
	public String toString() {
		return "CriteriaDTO [page=" + page + ", perPageNum=" + perPageNum + ", keyword=" + keyword + ", search_option="
				+ search_option + ", sort_type=" + sort_type + "]";
	}
	
}
