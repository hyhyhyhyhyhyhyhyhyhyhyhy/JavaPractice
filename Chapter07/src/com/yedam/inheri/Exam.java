package com.yedam.inheri;

public class Exam extends OverrideExam {

	
	//자식 클래스 : 우클릭 > source > override/implement 선택하면 오버라이딩할 항목 선택가능
	@Override
	public void method1() {
		System.out.println("자식 클래스의 method1");
		super.method1(); //부모가 가지고 있는 메소드를 가져온다
		super.method2();
	}
	
	
	
	
	
	
	
}
