package com.yedam.hw.inter;

//1) Keypad 인터페이스를 정의한다.
public interface Keypad {
//- 다음과 같이 상수 필드를 정의한다.
	public int NORMAL_MODE = 0;
	public int HARD_MODE = 1;

//- 다음과 같이 추상 메서드를 정의한다.
//	왼쪽에서 위쪽 버튼을 눌렀을 때 동작하는 기능
	public abstract void leftUpButton();

//왼쪽에서 아래쪽 버튼을 눌렀을 때 동작하는 기능
	public abstract void leftDownButton();

//오른쪽에서 위쪽 버튼을 눌렀을 때 동작하는 기능
	public abstract void rightUpButton();

//오른쪽에서 아래쪽 버튼을 눌렀을 때 동작하는 기능
	public abstract void rightDownButton();

//모드를 바꾸고 현재 모드를 출력하는 기능 ( NORMAL_MODE -> HARD_MODE / HARD_MODE -> NORMAL_MODE)
	public abstract void changeMode();
}