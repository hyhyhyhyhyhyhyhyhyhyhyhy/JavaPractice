package com.yedam.homework;

public class RPGgame implements Keypad{
	
	//필드
	int gameMode;
	
	
	
	//생성자
	public RPGgame() {
		
	}
	
	//메소드
	
	

	@Override
	public void leftUpButton() {
		System.out.println("캐릭터가 위쪽으로 이동한다");
		
	}

	@Override
	public void leftDownButton() {
		System.out.println("캐릭터가 아래쪽으로 이동한다");
		
	}

	@Override
	public void rightUpButton() {
		
	}

	@Override
	public void rightDownButton() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeMode() {
		// TODO Auto-generated method stub
		
	}
	
	
}
