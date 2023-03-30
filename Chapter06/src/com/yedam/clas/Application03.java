package com.yedam.clas;

public class Application03 {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		//메소드 호출
//		cal.sum(10,20);
		
		int result = cal.sum3(new int[] {1,2,3,4,5,6,76,87,9});
		System.out.println("sum3 : " + result);
		
		result = cal.sum4(1,2,3,4,5,6,7,8,9);
		System.out.println("sum4 : " + result);
	}
}
