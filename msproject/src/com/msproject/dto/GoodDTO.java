package com.msproject.dto;

public class GoodDTO {
	private String id;
	private int bno;
	
	public GoodDTO() {
		// TODO Auto-generated constructor stub
	}

	public GoodDTO(String id, int bno) {
		super();
		this.id = id;
		this.bno = bno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	@Override
	public String toString() {
		return "GoodDTO [id=" + id + ", bno=" + bno + "]";
	}
	
}
