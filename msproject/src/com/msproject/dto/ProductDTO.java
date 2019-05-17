package com.msproject.dto;

import java.util.Date;

public class ProductDTO {
	private String p_code;
	private String p_name;
	private int p_price;
	private String p_type;
	private String p_img;
	private int p_cnt;
	private int p_good;
	private Date date;
	
	public ProductDTO() {
		// TODO Auto-generated constructor stub
	}

	public ProductDTO(String p_code, String p_name, int p_price, String p_type, String p_img, int p_cnt, int p_good,
			Date date) {
		super();
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_type = p_type;
		this.p_img = p_img;
		this.p_cnt = p_cnt;
		this.p_good = p_good;
		this.date = date;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public String getP_type() {
		return p_type;
	}

	public void setP_type(String p_type) {
		this.p_type = p_type;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public int getP_cnt() {
		return p_cnt;
	}

	public void setP_cnt(int p_cnt) {
		this.p_cnt = p_cnt;
	}

	public int getP_good() {
		return p_good;
	}

	public void setP_good(int p_good) {
		this.p_good = p_good;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "ProductDTO [p_code=" + p_code + ", p_name=" + p_name + ", p_price=" + p_price + ", p_type=" + p_type
				+ ", p_img=" + p_img + ", p_cnt=" + p_cnt + ", p_good=" + p_good + ", date=" + date + "]";
	}
}
