package com.yedam.oop;

public class Student {
	//학생이름, 학번, 국영수 점수를 가지는 학생
	//필드
	String stdName;
	int stdNo;
	int kor;
	int eng;
	int math;
	
	//기본 생성자와 모든 데이터를 초기화 할 수 있다.

	public Student() {
		
	}
	public Student(String stdName, int stdNo, int kor, int eng, int math) {
		this.stdName = stdName;
		this.stdNo = stdNo;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	
	//메소드
	void getInfo() {
		System.out.println("이름 : " + stdName);
		System.out.println("학번 : " + stdNo);
		System.out.println("총점 : " + sum());
		System.out.println("평균 : " + avg());
	}
	
	int sum() {
		return kor+eng+math;
	}
	double avg() {
		return (double)sum()/3;
	}
	
	//학생의 정보를 출력하는 getInfo()
	//1)총점
	//2)평균
	//getInfo출력 결과
	//------------------
	//이름 : 김또치
	//학번 : 20230330
	//총점 : 200
	//평균 : 68.xxxx
}
