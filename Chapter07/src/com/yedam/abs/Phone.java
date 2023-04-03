package com.yedam.abs;

public abstract class Phone {
	public String owner;
	
	public Phone(String owner) {
		this.owner = owner;
	}
	
	public void turnOn() {
		System.out.println("폰 전원을 켭니다.");
	}
	
	//추상 메소드 : 상속받은 실제 클래스(자식 클래스)에서 반.드.시 
	public abstract void turnOff();
	
}
