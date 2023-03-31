package com.yedam.access;

public class Stu_application {

	public static void main(String[] args) {
		//인스턴스 생성
		Student std = new Student();
		
		std.setStdName("김또치");
		std.setStdGrade("2학년");
		std.setMajor("컴공");
		std.setProgramming(100); //-100으로 값을 입력할 경우, 세터에서 설정해놓은 if 문이 작동해서 console에서 0으로 보임
		std.setDatabase(50);
		std.setOs(100);
		
		System.out.println("이름 : " + std.getStdName());
		System.out.println("학과 : " + std.getMajor());
		System.out.println("학년 : " + std.getStdGrade());
		System.out.println("프로그래밍 점수 : " + std.getProgramming());
		System.out.println("디비 점수 : " + std.getDatabase());
		System.out.println("운영체제 : " + std.getOs());

	}

}
