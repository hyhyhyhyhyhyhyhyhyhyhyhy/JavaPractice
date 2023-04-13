package com.yedam.member;

import java.sql.Date;

import lombok.Data;

@Data

public class Member {

	
//	NAME      NOT NULL VARCHAR2(15) 
//	ID        NOT NULL VARCHAR2(20) 
//	PW        NOT NULL VARCHAR2(30) 
//	MOBILE             NUMBER(15)   
//	SIGN_DATE          DATE         
//	GRADE              CHAR(1)      
	
	private String id;
	private String pw;
	private String name;
	private int mobile;
	private Date signDate;
	
	private String ptTrainer;
	private int ptTotal;
	private int ptIng;
	private int ptLeft;

	private int regiMonth;
	private Date startDate;
	private Date expireDate;
	private String grade;
	private int avaExtendDay;
	private int extendLeft;
	
	
}
