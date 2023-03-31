package com.yedam.inheri;

public class Phone_application {

	public static void main(String[] args) {
		//자식 클래스 객체 dmb
		DmbCellPhone dmb = new DmbCellPhone(1, "white", "자바폰");
		
		//자식 클래스 객체 dmb2
		DmbCellPhone dmb2 = new DmbCellPhone(2, "black", "디비폰");
		
		//부모 클래스 메소드 사용
		dmb.powerOn();
		dmb.powerOff();
		dmb.bell();
		dmb.hangUp();
		
		//자식 클래스 메소드 사용
		dmb.turnOnDMB();
		dmb.turnOffDMB();

	}

}
