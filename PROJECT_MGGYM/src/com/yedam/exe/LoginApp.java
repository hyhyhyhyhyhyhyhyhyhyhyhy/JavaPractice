package com.yedam.exe;

import java.util.Scanner;

import com.yedam.afe.AFEService;
import com.yedam.extension.ExtensionService;
import com.yedam.member.MemberService;
import com.yedam.pt.PtService;

public class LoginApp {
	
	Scanner sc = new Scanner(System.in);
		
	int menu = 0;
	MemberService ms = new MemberService();
	ExtensionService es = new ExtensionService();
	PtService ps = new PtService();
	AFEService as = new AFEService();
	
	public LoginApp() {
		loginList();
	}
	
	
	//로그인 - 전체 메뉴
	private void loginMenu() {
		if(MemberService.memberState.getGrade() == null) {
			System.out.println("등록이 되지 않은 사용자입니다. 등록 후 이용부탁드립니다.");
			System.out.println();
			return;
		}else if(MemberService.memberState.getGrade().equals("M")) {
			System.out.println();
			System.out.println("【 관리자 모드 】");
			System.out.println("───────────────────────────────────────────────────────────────────────────");
			System.out.println(" １. 회원정보 조회 | ２. 회원 등록 | ３. 회원 정보 수정 | ４. 연장 조회 | ５. 로그아웃 ");
			System.out.println("───────────────────────────────────────────────────────────────────────────");
		}else {
			System.out.println();
			System.out.println("【 사용자 모드 】");
			System.out.println("────────────────────────────────────────────────");
			System.out.println(" １. 나의 믓GYM | ２. 나의 믓GYM 관리 | ３. 로그아웃 ");
			System.out.println("────────────────────────────────────────────────");
		}
		System.out.print("선택 > ");
		menu = Integer.parseInt(sc.nextLine());
	}
	
	
	//로그인 - 전체 메뉴 - 사용자/관리자별 지정메뉴
	private void loginList() {
		while(true) {
			loginMenu();
			if(MemberService.memberState.getGrade() == null) {
				break;
			}else if(MemberService.memberState.getGrade().equals("M")) {
				if(menu == 1) {
					//회원 조회
					//세부항목 > 전체회원 조회, 회원명 조회, 등급별 조회
					staffSubMenu1();
				}else if(menu == 2) {
					//회원 등록
					ms.memberAdd();
				}else if(menu == 3) {
					//회원 정보 수정 (memberService - update)
					//세부항목 > 재등록 회원 수정, PT 회원 수정, 회원 삭제
					staffSubMenu3();
				}else if(menu == 4) {
					//연장 관리 (extensionService)
					as.applyExtension();
				}else if(menu == 5) {
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
					//로그아웃
					ms.logout();
					break;
				}
			}
			
		}
	}
	
	
	//관리자 메뉴 1
	private void staffSubMenu1() {
		
		System.out.println("１. 전체회원 조회 | ２. 회원명 조회 | ３. 등급별 조회 | ４. 이전화면 ");
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
	
	//관리자 메뉴 3
	private void staffSubMenu3() {
		
		System.out.println("１. 재등록 회원 수정 | ２. pt 회원 수정 | ３. 회원 삭제 | ４. 이전화면 ");
		System.out.print("선택 > ");
		int select = Integer.parseInt(sc.nextLine());
		
		switch(select) {
		case 1:
			es.memberReregi();
			break;
		case 2:
			ps.ptMemberUpdate();
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
	
	
	//사용자 메뉴
	
	private void userSubMenu() {
		
		System.out.println("\n〔 회원 정보 및 연장 신청 〕");
		System.out.println("─────────────────────────────────────────────");
		System.out.println(" １. 비밀번호 수정 | ２. 연락처 수정 | ３. 연장 신청");
		System.out.println("─────────────────────────────────────────────");
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
			as.applyExtension();
			break;
		default:
			break;
		}
		
		
	}
	
	
	
	
	
	
	
	
}