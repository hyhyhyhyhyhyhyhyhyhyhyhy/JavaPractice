package com.yedam.app;

import java.util.Scanner;

public class StudentApp {

	Scanner sc = new Scanner(System.in);
	
	int selNo = 0;
	
	public StudentApp() {
		run();
	}
	
	private void run() {
		while(true) {
			System.out.println("1. 학생 정보 조회(전체 조회) | 2. 학생 등록 | 3. 학생 정보 삭제 | 4. 전공 변경 | 5. 종료");
			System.out.print("선택 > ");
			selNo = Integer.parseInt(sc.nextLine());
			
			if(selNo == 1) {
				//학생 정보 조회 메소드
				
			}else if(selNo == 2) {
				
			}else if(selNo == 3) {
				
			}else if(selNo == 4) {
				
			}else if(selNo == 5) {
				System.out.println("프로그램 종료");
				break;
			}
		}
	}
	
	
	
	
	
}
