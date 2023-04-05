package com.yedam.minitest;

import java.util.Scanner;

public class TestCard {
	Scanner sc = new Scanner(System.in);
	
	//필드
	int cardNo;
	String validDate;
	int cvc;
	
	
	//생성자
	TestCard(int cardNo, String validDate, int cvc){
		this.cardNo = cardNo;
		this.validDate = validDate;
		this.cvc = cvc;
	}

	
	//메소드
	public int getCardNo() {
		return cardNo;
	}


	public String getValidDate() {
		return validDate;
	}


	public int getCvc() {
		return cvc;
	}
	
	public void showCardInfo() {
		System.out.println("Card NO : " + this.cardNo + ", 유효기간 : " + this.validDate + ", CVC : " + this.cvc);
	}
	

}
