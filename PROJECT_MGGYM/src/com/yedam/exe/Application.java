package com.yedam.exe;

import java.util.Scanner;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	int num = 0;
	
	public Application() {
		run();
	}
	
	private void run() {
		
		while(true) {
			System.out.println("======================================================================================");
			System.out.println("※믓GYM은 100% 회원제로 이용가능한 헬스장입니다. 등록 및 회원가입 후 이용가능합니다. 오늘도 쇠질 화이팅♡");
			System.out.println("======================================================================================");
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 종료 ");
			num = Integer.parseInt(sc.nextLine());
			
			if(num == 1) {
				//회원가입 메소드 필요
			}else if(num == 2) {
				//로그인 실행 메소드 필요
			}else if(num == 3) {
				System.out.println("프로그램 종료");
				break;
			}		
		}
	}
	
	
	
	

		
		
		
		

	
	
	
	
	
	
}
