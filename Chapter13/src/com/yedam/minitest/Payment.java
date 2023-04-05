package com.yedam.minitest;

public interface Payment {
	//상수 필드
	public static final double ONLINE_PAYMENT_RATIO = 0.05;
	public static final double OFFLINE_PAYMENT_RATIO = 0.03;
	
	//추상 메소드
	
	public abstract int online(int price);
	public abstract int offline(int price);
	public abstract void showInfo();
	
	
}
