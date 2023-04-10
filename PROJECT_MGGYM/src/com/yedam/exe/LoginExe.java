package com.yedam.exe;

import java.util.Scanner;

import com.yedam.member.MemberService;

public class LoginExe {
	
	Scanner sc = new Scanner(System.in);
	
	int menu = 0;
	
	// 회원가입 고객 정보 입력
	public void memberJoin() {
		String username = "";
		String userid = "";
		String userpw = "";
		String recheckpw = "";
		int usermobile = 0;
		boolean run = true;
		
		while(run) {
			

		}
	
	
	
	
	}


	
	
//	System.out.print("이름 > ");
//	username = sc.nextLine();			
//	
//	System.out.print("아이디 > ");
//	userid = sc.nextLine();
//	
//	System.out.print("비밀번호 > ");
//	userpw = sc.nextLine();
//	
//	System.out.print("비밀번호 확인 > ");
//	recheckpw = sc.nextLine();
//	
//	System.out.print("휴대폰 번호 > ");
//	usermobile = Integer.parseInt(sc.nextLine());	
	
	
	
	
	
	
	
	
	//로그인이 완료되었을 때 보이는 전체 메뉴 보임과 동시에 입력값을 받을 수 있도록
	private void menu() {
		if(MemberService.memberStatus.getMemberType().equals("M")) {
			System.out.println("1. 회원정보 조회 | 2. 회원 등록 | 3. 회원 정보 수정 | 4. 연장 관리 | 5. 락커 관리 | 6. 공지사항 ");
		}else {
			System.out.println("1. 나의 믓GYM | 2. 내 정보 수정 | 3. 공지사항 게시판 확인");
		}
		System.out.print("선택 메뉴 > ");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}