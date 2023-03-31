package com.yedam.inheri;

public class Inheri_application {

	public static void main(String[] args) {
		Child child = new Child();
		
		//Child 클래스의 부모클래스인 Parent 클래스 내용을 가지고 올 수 있다. (부모클래스의 필드 메소드 전부)
		child.lastName = "이";
		child.getInfo();
//		child.money = 1000; 부모 클래스에서 필드의 money는 막아놓았기 때문에 입력 안됨
		
		
		
		
		
		
		
		
	}

}
