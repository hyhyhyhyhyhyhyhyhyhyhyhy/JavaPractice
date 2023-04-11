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
	
	private String id;
	private String pw;
	private String name;
	private int mobile;
	private Date signDate;
	private int regiMonth;
	private Date startDate;
	private Date expireDate;
	private String grade;
	
	private String ptTrainer;
	private int ptTotal;
	private int ptLeft;
	
	private String extendApply;
	private int avaExtendDay;
	private int extendLeft;
	
	
}
