package com.yedam.exe;

import java.util.Scanner;

import com.yedam.member.MemberService;

public class LoginExe {
	
	Scanner sc = new Scanner(System.in);
		
	int menu = 0;
	MemberService ms = new MemberService();
	
	public LoginExe() {
		loginList();
	}
	
	//로그인 후 세부 항목 실행 메소드
	private void loginList() {
		while(true) {
			loginMenu();
			if(MemberService.memberState.getGrade().equals("M")) {
				if(menu == 1) {
					//회원 조회 (memberservice join ptservice)
					//세부항목 > 전체회원 조회, 회원명 조회, 등급별 조회
					
				}else if(menu == 2) {
					//회원 등록 (memberservice - insert into)
					
				}else if(menu == 3) {
					//회원 정보 수정 (memberservice - update)
					//세부항목 > 재등록 회원 수정, PT 회원 수정, 회원 삭제
					
				}else if(menu == 4) {
					//연장 관리 (extensionservice)
					
				}else if(menu == 5) {
					//공지사항 게시판 보기, 수정, 삭제 항목 만들어야 함
				}else if(menu == 6) {
					//로그아웃
					ms.logout();
					break;
				}
			}else {
				if(menu == 1) {
					//내 정보 조회 (memberservice join ptservice) // 단건조회 활용할 수 있을까?
					
				}else if(menu == 2) {
					//내 정보 관리 (memberservice)
					//세부항목 > 비밀번호 수정, 연락처 수정, 연장 신청
					
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
			System.out.println("1. 회원정보 조회 | 2. 회원 등록 | 3. 회원 정보 수정 | 4. 연장 관리 | 5. 공지사항 ");
		}else {
			System.out.println("1. 나의 믓GYM | 2. 내 정보 수정 | 3. 공지사항 게시판 확인");
		}
		System.out.print("선택 메뉴 > ");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	
	//관리자 조회 세부메뉴
	private void subMenu() {
		int select = Integer.parseInt(sc.nextLine());
		
		System.out.println("1. 전체회원 조회 | 2. 회원명 조회 | 3. 등급별 조회 | 4. 이전화면");
		
		switch(select) {
		case 1:
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			break;
		default:
			break;
		}
		
		
	}
	
	
	
	
	
	
	
	
	
}