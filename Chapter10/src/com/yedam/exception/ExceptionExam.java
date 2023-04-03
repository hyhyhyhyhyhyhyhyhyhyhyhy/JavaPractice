package com.yedam.exception;

public class ExceptionExam {

	public static void main(String[] args) {
		//NullPointException ;
//		String data = null;
//		System.out.println(data.toString());
		
//		Example example = null;
//		System.out.println(example.toString());
		
		//ArrayIndexOutOfBoundsException
		int[] intAry = new int[3];
		
		intAry[2] = 3;
//		intAry[4] = 3; //Index 4 out of bounds for length 배열 길이 처음 선언한 것과 달라서 오류
		
//		for(int i=0; i<=intAry.length; i++) {
//			System.out.println(intAry[i]);
//		} //특히 반복문에서 이상한 범위 설정때문에 배열이 터지는 경우도 있으니 조심
		
		//NumberFormatException
		String str = "123";
		int val = Integer.parseInt(str);
		System.out.println(val);

		
		//예외
		String str2 = "자바";
		val = Integer.parseInt(str2);
		System.out.println(val);
		
		
		//ClassCastException
		//자동타입변환 된 객체를 강제타입변환 할 때 발생하는 것
		
		//정상
		Example exam = new Exam();
		Exam exam02 = (Exam) exam;
		
		
		//예외
		Example exam2 = new Exam();
		Exam02 exam03 = (Exam02) exam2;
		
		//ClassNotFoundException -> Class 파일 찾지 못할 때
		//실행메소드(main) 못 찾을 때 자주 발생
		
		//ArithmeticException ->분모가 0일때
		//double a = 1/0;
		
		//반복문을 종료하지 못하고 무한 루프 등등
		//OutofMemberError -> 메모리가 부족할 때
		//메모리 누수, memory leak
		
		//IOException -> 입출력 오류
		//file reading/writing 
		
		//FileNotFoundException
		//Java -> file reading -> 파일 경로가 안맞아서 파일 못찾음.
		//
		
		
		
		
	}

}
