package com.msproject.dto;

import java.util.Date;

public class MemberDTO {
	private int idnum;
	private String id;
	private String pw;
	private String name;
	private String phone;
	private String email;
	private String zipcode;
	private String addr1;
	private String addr2;
	private int birth_year;
	private int birth_month;
	private int birth_day;
	private Date regdate;
	
	public MemberDTO() {
		// TODO Auto-generated constructor stub
	}

	public MemberDTO(int idnum, String id, String pw, String name, String phone, String email, String zipcode,
			String addr1, String addr2, int birth_year, int birth_month, int birth_day, Date regdate) {
		super();
		this.idnum = idnum;
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.birth_year = birth_year;
		this.birth_month = birth_month;
		this.birth_day = birth_day;
		this.regdate = regdate;
	}
	
	

	public MemberDTO(String id, String pw, String name, String phone, String zipcode, String addr1, String addr2,
			String birth_year, String birth_month, String birth_day) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.zipcode = zipcode;
		this.addr1 = addr1;
		this.addr2 = addr2;
		this.birth_year = Integer.parseInt(birth_year);
		this.birth_month = Integer.parseInt(birth_month);
		this.birth_day = Integer.parseInt(birth_day);
	}

	public int getIdnum() {
		return idnum;
	}

	public void setIdnum(int idnum) {
		this.idnum = idnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public int getBirth_year() {
		return birth_year;
	}

	public void setBirth_year(int birth_year) {
		this.birth_year = birth_year;
	}

	public int getbirth_month() {
		return birth_month;
	}

	public void setbirth_month(int birth_month) {
		this.birth_month = birth_month;
	}

	public int getBirth_day() {
		return birth_day;
	}

	public void setBirth_day(int birth_day) {
		this.birth_day = birth_day;
	}

	public Date getRegdate() {
		return regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public void setBirth_year(String birth_year2) {
		this.birth_year = Integer.parseInt(birth_year2);	}

	public void setbirth_month(String birth_month2) {
		this.birth_month = Integer.parseInt(birth_month2);		
	}
	public void setBirth_day(String birth_day2) {
		this.birth_day = Integer.parseInt(birth_day2);		
	}
	
	@Override
	public String toString() {
		return "MemberDTO [idnum=" + idnum + ", id=" + id + ", pw=" + pw + ", name=" + name + ", phone=" + phone
				+ ", email=" + email + ", zipcode=" + zipcode + ", addr1=" + addr1 + ", addr2=" + addr2
				+ ", birth_year=" + birth_year + ", birth_month=" + birth_month + ", birth_day=" + birth_day
				+ ", regdate=" + regdate + "]";
	}

	
}
