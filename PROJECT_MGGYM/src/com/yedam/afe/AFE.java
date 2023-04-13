package com.yedam.afe;

import java.sql.Date;

import lombok.Data;

@Data

public class AFE {

//	APPLY_NO               NUMBER(4)    
//	APPLYER_NAME  NOT NULL VARCHAR2(15) 
//	EXTEND_PERIOD          NUMBER(3)    
//	APPLIED_DATE           DATE         
//	EXPECTED_DATE          DATE       
	
	private int applyNo;
	private String applyerName;
	private int extendPeriod;
	private Date appliedDate;
	private Date expectedDate;	
	
	
}
