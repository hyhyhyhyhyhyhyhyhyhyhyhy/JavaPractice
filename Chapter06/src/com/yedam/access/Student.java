package com.yedam.access;

public class Student {
	//이름, 학과, 학년, 과목별 점수
	//programming, database, os 
	//모든 필드 => 접근 제한자 private (외부에서 해당 필드에 접근 못하도록 막아줌)
	//setter를 통해 필드 초기화
	//getter를 통해 필드(데이터) reading
	//getInfo를 활용해서 학생 정보 출력 기능
	
	//필드
	private String stdName;
	private String major;
	private String stdGrade;
	private int programming;
	private int database;
	private int os;
	
	//생성자
	
	//메소드 (setter)
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	
	public String setStdName() {
		return stdName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getStdGrade() {
		return stdGrade;
	}

	public void setStdGrade(String stdGrade) {
		this.stdGrade = stdGrade;
	}

	public int getProgramming() {
		//programming 점수를 0.5배 해서 성적을 표현하는 방법
		return (int)(programming*1.5);
	}

	public void setProgramming(int programming) {
		//만약 programming 점수가 0 미만인 점수가 입력될 경우,
		//그 점수를 0점으로 처리 if not, 입력한 점수를 객체에 저장
		
//		방법 1
//		if(programming < 0) {
//			this.programming = 0;
//			return; // 메소드 종료
//		}else {
//			this.programming = programming;			
//		}
		
//		방법 2 = 삼항 연산자
		this.programming = (programming<0) ? 0 : programming;
		
	}

	public int getDatabase() {
		return database;
	}

	public void setDatabase(int database) {
		this.database = database;
	}

	public int getOs() {
		return os;
	}

	public void setOs(int os) {
		this.os = os;
	}

	public String getStdName() {
		return stdName;
	}
	
}
