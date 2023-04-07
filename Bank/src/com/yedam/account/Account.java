package com.yedam.account;

import java.sql.Date;

import lombok.Data;

@Data


public class Account {
//	ACCOUNT_ID  NOT NULL NUMBER 
//	CUSTOMER_ID          NUMBER 
//	BALANCE              NUMBER 
//	CREDATE              DATE   
	
	private int accountId;
	private int customerId;
	private int balance;
	private Date credate;
	
	
	//JOIN 테이블 사용
	//1) Join 용 클래스 만들기
	//2) 기준 클래스 설정 (데이터 조회 시 좀 더 데이터가 많이 나오는 column) (v)
//		> join 했을 때 합쳐지는 데이터를 기준 클래스 DTO에 필드 추가하기
//	 	example ) 계좌 조회 시 고객 정보 같이 나오도록
	
	//Join 할 때 customer 테이블에 있는 customer_name을 저장하기 위해
	//필드에 customer 테이블의 column인 customer_name 추가 (account column이 더 많아서 여기에 추가하는 것)
	private String customerName;
	
	
}
