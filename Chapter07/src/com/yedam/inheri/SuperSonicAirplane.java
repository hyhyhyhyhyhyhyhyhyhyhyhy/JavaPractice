package com.yedam.inheri;

public class SuperSonicAirplane extends AIrplane {
	//필드
	public static final int NORMAL = 1;
	public static final int SUPERSONIC = 3;
	
	public int flymode = NORMAL;

	@Override
	public void fly() {
		if(flymode == SUPERSONIC) {
			System.out.println("초음속 모드");
		}else {
			super.fly();
		}
	}
	
	
}
