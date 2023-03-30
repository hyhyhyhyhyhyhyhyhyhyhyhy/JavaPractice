package com.yedam.clas;

public class Calculator {
	
	//필드
	
	//생성자
	
	//메소드
//	void sum(int x, int y) {
//		int result = x + y;
//		System.out.println(x + " + " + y + " = " + result);
		
	//매개변수의 개수를 모를 경우,
		int sum3(int[] intAry) {
			int result = 0;
			for(int i = 0; i<intAry.length; i++) {
				result += intAry[i];
			}
			return result;
		}
		//...활용
		int sum4(int ...intAry) {
			int result = 0;
			for(int i = 0; i<intAry.length; i++) {
				result = intAry[i];
			}
			return result;
		}
		
	}
	
