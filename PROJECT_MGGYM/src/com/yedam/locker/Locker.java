package com.yedam.locker;

import java.sql.Date;

import lombok.Data;

@Data

public class Locker {

//	MEMBER_ID          NOT NULL VARCHAR2(20) 
//	MEMBER_MOBILE               NUMBER(15)   
//	USE_LOCKER                  CHAR(1)      
//	LOCKER_START_DATE           DATE         
//	LOCKER_EXPIRE_DATE          DATE         
//	MEMBER_TYPE        NOT NULL CHAR(2)    
	
	private String memberId;
	private int memberMobile;
	private String useLocker;
	private Date lockerStartDate;
	private Date lockerExpireDate;
	private String memberType;
	
	
}
