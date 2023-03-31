package com.yedam.inheri;

public class Airplane_application {

	public static void main(String[] args) {
		SuperSonicAirplane sa = new SuperSonicAirplane();
		// sa 객체는 flymode가 normal 인 상태로 객체 생성
		
		sa.takeOff();
		
		sa.fly();
		
		sa.flymode = SuperSonicAirplane.SUPERSONIC;
		
		sa.fly();
		
		sa.flymode = SuperSonicAirplane.NORMAL;

		sa.fly();
		
		sa.land();
	}

}
