package com.yedam.minitest;

public class TestTossCard extends TestCard{
	//필드
	String company = "Toss";
	String cardStaff;
	
	//생성자
	TestTossCard(String cardStaff, int cardNo, String validDate, int cvc){
		super(cardNo, validDate,cvc);
		this.cardStaff = cardStaff;
	}
	
	//메소드
	@Override
	public void showCardInfo() {
		System.out.println("카드정보 - Card NO, " + this.cardNo);
		System.out.println("담당직원 - " + this.cardStaff + ", " + this.company);
	}
	
	
	
}
