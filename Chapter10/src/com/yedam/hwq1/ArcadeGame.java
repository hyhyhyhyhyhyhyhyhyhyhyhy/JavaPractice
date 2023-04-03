package com.yedam.hwq1;

public class ArcadeGame implements Keypad {

	//필드
	int currentMode = NORMAL_MODE;
	
	
	//생성자
	public ArcadeGame() {
		System.out.println("ArcadeGame 실행");
	}
	
	
	//메소드
	

	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 앞쪽으로 이동한다");
	}

	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 뒤쪽으로 이동한다");
	}

	@Override
	public void rightUpButton() {
		if(currentMode == 0) {
			System.out.println("캐릭터가 일반 공격");
		}else {
			System.out.println("캐릭터가 연속 공격");
		}
	
	}

	@Override
	public void rightDownButton() {
		if(currentMode == 0) {
			System.out.println("캐릭터가 HIT 공격");
		}else {
			System.out.println("캐릭터가 Double HIT 공격");
		}
	}

	@Override
	public void changeMode() {
		if(currentMode == 0) {
			currentMode = 1;
			System.out.println("현재 모드 : HARD_MODE");
		}else {
			currentMode = 0;
			System.out.println("현재 모드 : NORMAL_MODE");
		}
	}
	
}
