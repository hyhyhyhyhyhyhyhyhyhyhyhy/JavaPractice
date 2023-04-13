package com.yedam.pt;

import lombok.Data;

@Data

public class Pt {

//	GRADE               CHAR(1)      
//	ID         NOT NULL VARCHAR2(20) 
//	PT_TRAINER          VARCHAR2(12) 
//	PT_TOTAL            NUMBER(3)    
//	PT_ING              NUMBER(3)    
//	PT_LEFT             NUMBER(3)    
	
	private String grade;
	private String id;
	private String ptTrainer;
	private int ptTotal;
	private int ptIng;
	private int ptLeft;
	
	private String name;
	
}
