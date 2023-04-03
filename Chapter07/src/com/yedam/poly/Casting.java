package com.yedam.poly;

public class Casting {

	//매개변수를 활용한 다형성
	public static void method1(Parent parent) {
		if(parent instanceof Child) {
			Child child = (Child)parent;
			System.out.println("Casting 성공");
		}else {
			System.out.println("Casting 실패");
		}
	}
	
	
	public static void main(String[] args) {
		Parent p1 = new Child(); //Child를 사용해서 만들었을 때와, Child02로 만들었을 때 캐스팅 성공실패 출력결과가 달라진다.
		
//		Child child = (Child)p1;

//		Child child = (Child)p1;		
		
//		Child02 child = (CHild02)p1;
//		child.method1();
		
		method1(p1);
	}

}
