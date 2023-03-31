package com.yedam.inheri;

public class Calcu_application {

	public static void main(String[] args) {
		Compute com = new Compute();
		com.areaCircle(10.1); //자식 클래스의 메소드 실행 이라는 문구가 뜨는 것으로
							// 메소드 오버라이딩이 잘 되었다고 할 수 있다.

		
		Exam exam = new Exam();
		exam.method1();
//		exam.method2();
	}

}
