package com.yedam.exe;

import java.util.Scanner;

import com.yedam.member.MemberService;

public class Application {
	
	Scanner sc = new Scanner(System.in);
	int num = 0;
	
	MemberService ms = new MemberService();
	
	
	public Application() {
		run();
	}
	
	private void run() {
		
		while(true) {
			System.out.println("=========================================================================");
			System.out.println(" ※ 믓GYM은 100% 회원제로 이용가능한 헬스장입니다. \n   회원가입 후 로그인 이용 부탁드립니다. \n   오늘도 쇠질 화이팅♡");
			System.out.println("=========================================================================");
			System.out.println();
			System.out.println("1. 회원가입 | 2. 로그인 | 3. 종료 ");
			System.out.print("선택 > ");
			num = Integer.parseInt(sc.nextLine());
			System.out.println();
			
			if(num == 1) {
				//회원가입 실행 메소드
				ms.memberJoin();
			}else if(num == 2) {
				//로그인 실행 메소드
				ms.login();	
				new LoginExe();
			}else if(num == 3) {
				System.out.println("프로그램 종료");
				break;
			}		
		}
	}
	
	
	
	

		
		
		
		

	
	
	
	
	
	
}
