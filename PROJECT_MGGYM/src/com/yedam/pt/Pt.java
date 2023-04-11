package com.yedam.pt;

import lombok.Data;

@Data

public class Pt {

//	GRADE      NOT NULL CHAR(2)      
//	ID         NOT NULL VARCHAR2(20) 
//	NAME                VARCHAR2(15) 
//	PT_TRAINER          VARCHAR2(12) 
//	PT_TOTAL            NUMBER(3)    
//	PT_LEFT             NUMBER(3)  
	
	private String grade;
	private String id;
	private String name;
	private String ptTrainer;
	private String memberId;
	private int ptTotal;
	private int ptLeft;
	
}
