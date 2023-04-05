package com.yedam.minitest;

public class TestDGBCard extends TestCard{
	//필드
	String company = "대구은행";
	String cardStaff;
	
	//생성자
	TestDGBCard(String cardStaff, int cardNo, String validDate, int cvc){
		super(cardNo, validDate,cvc);
		this.cardStaff = cardStaff;
	}

	@Override
	public void showCardInfo() {
		super.showCardInfo();
		System.out.println("담당직원 - " + this.cardStaff + ", " + this.company);
	}
	
	//메소드
	
	
}
