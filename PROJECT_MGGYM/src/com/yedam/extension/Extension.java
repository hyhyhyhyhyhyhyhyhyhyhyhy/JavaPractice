package com.yedam.extension;

import java.sql.Date;

import lombok.Data;

@Data

public class Extension {

//	ID             NOT NULL VARCHAR2(20) 
//	NAME           NOT NULL VARCHAR2(15) 
//	REGI_MONTH              NUMBER(2)    
//	START_DATE              DATE         
//	EXPIRE_DATE             DATE         
//	AVA_EXTEND_DAY          NUMBER(3)    
//	APPLIED_DAY             NUMBER(3)    
//	EXTEND_LEFT             NUMBER(5)    
//	GRADE                   CHAR(1)      
	
	private int regiMonth;
	private Date startDate;
	private Date expireDate;
	private int avaExtendDay;
	private int appliedDay;
	private int extendLeft;
	private String grade;
	
	private String id;
	private String name;
	
	
}
