package com.yedam.hw.inter;

//- Keypad를 구현하는 클래스.
public class RPGgame implements Keypad {
//- 현재 모드를 값으로 가지는 필드를 가지며
private int currentMode;
//생성자를 이용하여 값을 초기화한후 "RPGgmae 실행"을 출력한다.
//  ( 단, 매개변수를 이용하지 않으며 최초의 값은 NORMAL_MODE 이다. )

public RPGgame() {
	currentMode = Keypad.NORMAL_MODE;
	System.out.println("RPGgame 실행");
}

@Override
public void leftUpButton() {
//	"캐릭터가 위쪽으로 이동한다"를 출력한다.
	System.out.println("캐릭터가 위쪽으로 이동한다");

}

@Override
public void leftDownButton() {
//	"캐릭터가 아래쪽으로 이동한다"를 출력한다.	
	System.out.println("캐릭터가 아래쪽으로 이동한다");
}

@Override
public void rightUpButton() {
//	- NORMAL_MODE : "캐릭터가 한칸단위로 점프한다."를 출력한다.
//	- HARD_MODE : "캐릭터가 두칸단위로 점프한다."를 출력한다.
	if (currentMode == Keypad.NORMAL_MODE) {
		System.out.println("캐릭터가 한칸단위로 점프한다.");
	} else if (currentMode == Keypad.HARD_MODE) {
		System.out.println("캐릭터가 두칸단위로 점프한다.");
	}
}

@Override
public void rightDownButton() {
//	- NORMAL_MODE : "캐릭터가 일반 공격."를 출력한다.
//	- HARD_MODE : "캐릭터가 HIT 공격."를 출력한다.
//	if (currentMode == Keypad.NORMAL_MODE) {
//		System.out.println("캐릭터가 일반 공격.");
//	} else if (currentMode == Keypad.HARD_MODE) {
//		System.out.println("캐릭터가 HIT 공격.");
//	}
	switch (currentMode) {
	case Keypad.NORMAL_MODE:
		System.out.println("캐릭터가 일반 공격.");
		break;
	case Keypad.HARD_MODE:
		System.out.println("캐릭터가 HIT 공격.");
		break;
	}

}

@Override
public void changeMode() {
//	모드를 바꾸고 현재 모드를 출력하는 기능
//	( NORMAL_MODE -> HARD_MODE / HARD_MODE -> NORMAL_MODE)
	if (currentMode == Keypad.NORMAL_MODE) {
		currentMode = Keypad.HARD_MODE;
		System.out.println("현재 모드 : Hard_Mode");
	} else if (currentMode == Keypad.HARD_MODE) {
		currentMode = Keypad.NORMAL_MODE;
		System.out.println("현재 모드 : Normal_Mode");
	}
}
}
