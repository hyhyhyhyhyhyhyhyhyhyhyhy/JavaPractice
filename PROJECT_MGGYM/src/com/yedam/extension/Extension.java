package com.yedam.extension;

import java.sql.Date;

import lombok.Data;

@Data

public class Extension {

//	START_DATE              DATE         
//	EXPIRE_DATE             DATE         
//	REGI_MONTH              NUMBER(2)    
//	AVA_EXTEND_DAY          NUMBER(3)    
//	APPLIED_DAY             NUMBER(3)    
//	EXTEND_LEFT             NUMBER(5)    
//	GRADE                   CHAR(2)       
	
	private Date startDate;
	private Date expireDate;
	private int regiMonth;
	private int avaExtendDay;
	private int appliedDay;
	private int extendLeft;
	private String grade;
	
	
}
