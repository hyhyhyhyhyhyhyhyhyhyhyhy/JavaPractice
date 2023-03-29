package com.yedam.oop;

public class Application {

	public static void main(String[] args) {
		Smartphone s1 = new Smartphone();
		//s1 객체에 정보 대입
		s1.name = "아이폰";
		s1.maker = "애플";
		s1.price = 1200000;
		
		//s1 객체의 메소드 사용
		s1.getInfo();
		
		System.out.println(s1.name);
		System.out.println(s1.maker);
		System.out.println(s1.price);
		
		Smartphone s2 = new Smartphone();
		
		System.out.println(s2.name);
		System.out.println(s2.maker);
		System.out.println(s2.price);
	}

}
