package com.msproject.dto;

public class PageMakerDTO {
	int totalCount;				// 전체 페이지 개수
	int startPage;				// 
	int endPage;
	boolean prev;
	boolean next;
	int displayPageNum = 10;
	int displayPagehalf = 4;
	int finalPage;
	CriteriaDTO criDto;
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
		calcData();
	}
	
	private void calcData() {
		/*
		endPage = (int)Math.ceil(criDto.getPage()/(double)displayPageNum)*displayPageNum;
		startPage = (endPage - displayPageNum)+1;
		int tempEndPage = (int)(Math.ceil(totalCount/(double)(criDto.getPerPageNum()/criDto.getPage())));
		if(endPage>tempEndPage) {
			endPage = tempEndPage;
		}
		
		prev = startPage==1?false:true;
		next = (endPage * (criDto.getPerPageNum()/criDto.getPage()))>=totalCount ? false:true;
		
		finalPage = (int)Math.ceil(totalCount/(double)(displayPageNum));
		*/
		int temp;
		finalPage = (int)Math.ceil(totalCount/(double)(displayPageNum));
		
		if(criDto.getPage()-displayPagehalf<=0) {
			temp = criDto.getPage()-1;
			if(finalPage <= (displayPagehalf*2+1))
				endPage = finalPage;
				else
			endPage = ((displayPagehalf*2)-temp)+criDto.getPage();
			startPage = 1;
			if(criDto.getPage()<1)
				criDto.setPage(1);
			else if(criDto.getPage()>finalPage)
				criDto.setPage(finalPage);
		}else if(criDto.getPage()+displayPagehalf > finalPage) {
			temp = finalPage - criDto.getPage();
			startPage = criDto.getPage()-((displayPagehalf*2)-temp);
			endPage = finalPage;
			if(criDto.getPage()>finalPage) {
				criDto.setPage(finalPage);
			}
		}else {
			startPage = criDto.getPage()-displayPagehalf;
			endPage = criDto.getPage()+displayPagehalf;
		}
		prev = startPage==1?false:true;
		next = endPage == finalPage? false:true;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public boolean isPrev() {
		return prev;
	}
	public void setPrev(boolean prev) {
		this.prev = prev;
	}
	public boolean isNext() {
		return next;
	}
	public void setNext(boolean next) {
		this.next = next;
	}
	
	
	public CriteriaDTO getCriDto() {
		return criDto;
	}
	public void setCriDto(CriteriaDTO criDto) {
		this.criDto = criDto;
	}
	public int getDisplayPageNum() {
		return displayPageNum;
	}
	public void setDisplayPageNum(int displayPageNum) {
		this.displayPageNum = displayPageNum;
	}
	
	
	public int getFinalPage() {
		return finalPage;
	}
	public void setFinalPage(int finalPage) {
		this.finalPage = finalPage;
	}
	@Override
	public String toString() {
		return "PageMakerDTO [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", prev=" + prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", finalPage="
				+ finalPage + "]";
	}
	
	
}
