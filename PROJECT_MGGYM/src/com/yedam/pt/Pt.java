package com.yedam.pt;

import lombok.Data;

@Data

public class Pt {

//	PT_TRAINER                  VARCHAR2(12) 
//	MEMBER_ID          NOT NULL VARCHAR2(20) 
//	PT_COUNT                    NUMBER(3)    
//	PT_MEMBERSHIP_LEFT          NUMBER(3)
	
	private String ptTrainer;
	private String memberId;
	private int ptCount;
	private int ptMembershipLeft;
	
}
