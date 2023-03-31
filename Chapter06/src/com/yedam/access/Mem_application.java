package com.yedam.access;

public class Mem_application {

	public static void main(String[] args) {
		 Member obj1 = Member.getInstance();
		 Member obj2 = Member.getInstance();
		 
		 System.out.println(obj1); // 객체를 출력하면 주소를 출력한다.
		 System.out.println(obj2);
		 System.out.println(obj1 == obj2);
		 
		 obj1.getInfo();
		 System.out.println(obj2.age);
		 
	}

}
