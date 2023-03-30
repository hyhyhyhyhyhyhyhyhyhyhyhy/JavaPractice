package com.yedam.oop;

public class Application04 {
	
		static int a = 1;
		static void info() {
			System.out.println("Info 출력");
		}
		
		int field1;
	//메소드 영역에 포함되어 있는 정적 메소드, main문
	public static void main(String[] args) {
		System.out.println(1);
		
		info();
		
		Application04 temp = new Application04();
		temp.field1 = 1;
		
		System.out.println(StaticCal.PI);
		System.out.println(StaticCal.earthraddius);
		
		int result = StaticCal.plus(10, 20);
		
		StaticCal  cal = new StaticCal();
		
//		StaticCal.PI = 10; //오류 파이널 필드에 접근 못함 (실제로 실내 촬영이 거]\
		
		
			
			
			
			
			
			
		}
	}

