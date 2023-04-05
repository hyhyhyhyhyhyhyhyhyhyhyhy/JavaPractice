package com.yedam.minitest;

public class SimplePayment implements Payment{
	double simplePaymentRatio;
	
	SimplePayment(){
		
	}
	
	SimplePayment(double simplePaymentRatio){
		this.simplePaymentRatio = simplePaymentRatio;
	}

	@Override
	public int online(int price) {
		return (int) (price - (price*(ONLINE_PAYMENT_RATIO + simplePaymentRatio)));
	}

	@Override
	public int offline(int price) {
		return (int) (price - (price*(OFFLINE_PAYMENT_RATIO + simplePaymentRatio)));
	}

	@Override
	public void showInfo() {
		System.out.println("*** 카드로 결제 시 할인정보");
		double sonRatio = ONLINE_PAYMENT_RATIO + simplePaymentRatio;
		double soffRatio = OFFLINE_PAYMENT_RATIO + simplePaymentRatio;
		System.out.println("온라인 결제 시 총 할인율 : " + sonRatio);
		System.out.println("오프라인 결제 시 총 할인율 : " + soffRatio);
		
	}
}
