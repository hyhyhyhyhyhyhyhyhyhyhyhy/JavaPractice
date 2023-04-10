package com.yedam.extension;

import java.sql.Date;

import lombok.Data;

@Data

public class Extension {

//	MEMBER_ID         NOT NULL VARCHAR2(20) 
//	START_DATE                 DATE         
//	EXPIRE_DATE                DATE         
//	AVA_EXTEND_PERIOD          NUMBER(2)    
//	EXTEND_LEFT                NUMBER(5)    
//	MEMBER_TYPE       NOT NULL CHAR(2)      
	
	private String memberId;
	private Date startDate;
	private Date expireDate;
	private int avaExtendPeriod;
	private int extendLeft;
	private String memberType;
	
	
}
