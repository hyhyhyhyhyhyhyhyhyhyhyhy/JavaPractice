package com.yedam.member;

import java.sql.Date;

import lombok.Data;

@Data

public class Member {

	
//	ID             NOT NULL VARCHAR2(20) 
//	NAME           NOT NULL VARCHAR2(15) 
//	REGI_MONTH              NUMBER(2)    
//	START_DATE              DATE         
//	EXPIRE_DATE             DATE         
//	AVA_EXTEND_DAY          NUMBER(3)    
//	APPLIED_DAY             NUMBER(3)    
//	EXTEND_LEFT             NUMBER(5)    
//	GRADE                   CHAR(1)     
	
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
