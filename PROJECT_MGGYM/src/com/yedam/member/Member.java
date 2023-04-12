package com.yedam.member;

import java.sql.Date;

import lombok.Data;

@Data

public class Member {

	
//	ID          NOT NULL VARCHAR2(20) 
//	PW          NOT NULL VARCHAR2(30) 
//	NAME        NOT NULL VARCHAR2(15) 
//	MOBILE               NUMBER(15)   
//	SIGN_DATE            DATE         
//	REGI_MONTH           NUMBER(2)    
//	START_DATE           DATE         
//	EXPIRE_DATE          DATE         
//	GRADE                CHAR(2)  
	
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
	private int ptIng;
	private int ptLeft;
	
	private int avaExtendDay;
	private int extendLeft;
	
	
}
