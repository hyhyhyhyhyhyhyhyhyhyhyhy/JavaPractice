package com.yedam.minitest;

public class CardPayment implements Payment{
	//필드
	double cardRatio;
	
	//생성자
	CardPayment(){
		
	}
	CardPayment(double cardRatio){
		this.cardRatio = cardRatio;
	}

	@Override
	public int online(int price) {
		return (int) (price - (price*(ONLINE_PAYMENT_RATIO + cardRatio)));
	}

	@Override
	public int offline(int price) {
		return (int) (price - (price*(OFFLINE_PAYMENT_RATIO + cardRatio)));
	}

	@Override
	public void showInfo() {
		System.out.println("*** 카드로 결제 시 할인정보");
		double onRatio = ONLINE_PAYMENT_RATIO + cardRatio;
		double offRatio = OFFLINE_PAYMENT_RATIO + cardRatio;
		System.out.println("온라인 결제 시 총 할인율 : " + onRatio);
		System.out.println("오프라인 결제 시 총 할인율 : " + offRatio);
	}
	
}
