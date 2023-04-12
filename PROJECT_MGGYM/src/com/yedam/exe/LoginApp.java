package com.yedam.exe;

import java.util.Scanner;

import com.yedam.extension.ExtensionService;
import com.yedam.member.MemberService;

public class LoginApp {
	
	Scanner sc = new Scanner(System.in);
		
	int menu = 0;
	MemberService ms = new MemberService();
	ExtensionService es = new ExtensionService();
	
	public LoginApp() {
		loginList();
	}
	
	//로그인 후 세부 항목 실행 메소드
	private void loginList() {
		while(true) {
			loginMenu();
			if(MemberService.memberState.getGrade().equals("M")) {
				if(menu == 1) {
					//회원 조회
					//세부항목 > 전체회원 조회, 회원명 조회, 등급별 조회
					staffSubMenu1();
				}else if(menu == 2) {
					//회원 등록
					ms.memberAdd(null);
				}else if(menu == 3) {
					//회원 정보 수정 (memberService - update)
					//세부항목 > 재등록 회원 수정, PT 회원 수정, 회원 삭제
					staffSubMenu3();
				}else if(menu == 4) {
					//연장 관리 (extensionService)
					
				}else if(menu == 5) {
					//공지사항 게시판 보기, 수정, 삭제 항목 만들어야 함
				}else if(menu == 6) {
					//로그아웃
					ms.logout();
					break;
				}
			}else {
				if(menu == 1) {
					//내 정보 조회
					ms.getSearchMember();
				}else if(menu == 2) {
					//내 정보 관리 (memberService)
					//세부항목 > 비밀번호 수정, 연락처 수정, 연장 신청
					userSubMenu();
				}else if(menu == 3) {
					//공지사항 게시판 확인
				}else if(menu == 4) {
					//로그아웃
					ms.logout();
					break;
				}
			}
			
		}
	}

	
	
	//로그인이 완료되었을 때 보이는 전체 메뉴 보임과 동시에 입력값을 받을 수 있도록
	private void loginMenu() {
		if(MemberService.memberState.getGrade().equals("M")) {
			System.out.println();
			System.out.println("관리자로 로그인 중입니다.");
			System.out.println("1. 회원정보 조회 | 2. 회원 등록 | 3. 회원 정보 수정 | 4. 연장 관리 | 5. 공지사항 | 6. 로그아웃");
		}else{
			System.out.println();
			System.out.println("회원으로 로그인 중입니다.");
			System.out.println("1. 나의 믓GYM | 2. 내 정보 수정 | 3. 공지사항 게시판 확인 | 4. 로그아웃");
		}
		System.out.print("선택 > ");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	
	//관리자 조회 세부메뉴
	private void staffSubMenu1() {
		
		System.out.println("1. 전체회원 조회 | 2. 회원명 조회 | 3. 등급별 조회 | 4. 이전화면 ");
		System.out.print("선택 > ");
		int select = Integer.parseInt(sc.nextLine());
		
		switch(select) {
		case 1:
			ms.getMemberList();
			break;
		case 2:
			ms.getSearchMember();
			break;
		case 3:
			ms.getSearchGrade();
			break;
		case 4:
			loginMenu();
			break;
		default:
			break;
		}
		
		
	}
	
	//관리자 조회 세부메뉴
	private void staffSubMenu3() {
		
		System.out.println("1. 재등록 회원 수정 | 2. pt 회원 수정 | 3. 회원 삭제 | 4. 이전화면 ");
		System.out.print("선택 > ");
		int select = Integer.parseInt(sc.nextLine());
		
		switch(select) {
		case 1:
//			es.memberReregi();
			break;
		case 2:
			
			break;
		case 3:
			ms.memberDelete();
			break;
		case 4:
			loginMenu();
			break;
		default:
			break;
		}
	}
	
	
	//사용자 조회 세부메뉴
	
	private void userSubMenu() {
		
		System.out.println("1. 비밀번호 수정 | 2. 연락처 수정 | 3. 연장 신청");
		System.out.print("선택 > ");
		int select = Integer.parseInt(sc.nextLine());
		
		switch(select) {
		case 1:
			ms.userPwUpdate();
			break;
		case 2:
			ms.userMobileUpdate();
			break;
		case 3:
			
			break;
		default:
			break;
		}
		
		
	}
	
	
	
	
	
	
	
	
}