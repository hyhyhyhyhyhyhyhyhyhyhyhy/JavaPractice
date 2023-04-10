package com.yedam.member;

import java.sql.Date;

import lombok.Data;

@Data

public class Member {

	
//	MEMBER_ID     NOT NULL VARCHAR2(20) 
//	MEMBER_PW     NOT NULL VARCHAR2(30) 
//	MEMBER_NAME            VARCHAR2(12) 
//	MEMBER_MOBILE          NUMBER(15)   
//	SIGN_DATE              DATE         
//	START_DATE             DATE         
//	EXPIRE_DATE            DATE         
//	EXTENSION              NUMBER(2)    
//	MEMBER_TYPE   NOT NULL CHAR(2)
	
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberMobile;
	private Date signDate;
	private Date startDate;
	private Date expireDate;
	private int extension;
	private String memberType;
	
	
}
