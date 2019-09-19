package com.lsg.domain;

import java.sql.Date;

public class MemberVo {
/*	     create table tbl_member(
	  2  userId varchar2(50) not null,
	  3  userPass varchar2(100) not null,
	  4  userName varchar2(30) not null,
	  5  userPhon varchar2(20) not null,
	  6  userAddr1 varchar2(20) not null,
	  7  userAddr2 varchar2(50) not null,
	  8  userAddr3 varchar2(50) not null,
	  9  regidate date default sysdate,
	 10  verify number default 0,
	 11  primary key(userId)
	 12  );
*/	
	private String userId;
	private String userPass;
	private String userName;
	private String userPhon;
	private String userAddr1;
	private String userAddr2;
	private String userAddr3;
	private Date regDate;
	private int verify;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPass() {
		return userPass;
	}
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPhon() {
		return userPhon;
	}
	public void setUserPhon(String userPhon) {
		this.userPhon = userPhon;
	}
	public String getUserAddr1() {
		return userAddr1;
	}
	public void setUserAddr1(String userAddr1) {
		this.userAddr1 = userAddr1;
	}
	public String getUserAddr2() {
		return userAddr2;
	}
	public void setUserAddr2(String userAddr2) {
		this.userAddr2 = userAddr2;
	}
	public String getUserAddr3() {
		return userAddr3;
	}
	public void setUserAddr3(String userAddr3) {
		this.userAddr3 = userAddr3;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public int getVerify() {
		return verify;
	}
	public void setVerify(int verify) {
		this.verify = verify;
	}
	
	
	
	
}
