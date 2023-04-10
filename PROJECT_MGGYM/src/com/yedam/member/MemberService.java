package com.yedam.member;

import java.util.Scanner;

public class MemberService {

	Scanner sc = new Scanner(System.in);
	
	//회원가입
	
	public void memberJoin() {
		Member member = new Member();
		
		System.out.println("============ 회원가입 =============");
		System.out.print("이름 > ");
		String username = sc.nextLine();
		
		String memberId = "";
		while(true) {
			System.out.print("아이디 >");
			memberId = sc.nextLine();
			
			if(MemberDAO.getInstance().login(memberId) == null) {
				break;
			}else {
				System.out.println("이미 존재하는 아이디입니다.");
			}	
		}
		
		System.out.print("비밀번호 > ");
		String memberPw = sc.nextLine();
		
		while(true) {
			System.out.print("비밀번호 확인 > ");
			String memberPw2 = sc.nextLine();
			if(memberPw2 == memberPw) {
				break;
			}else {
				System.out.println("비밀번호가 다릅니다. 다시 확인하세요.");
			}
		}
		
		System.out.print("연락처 > ");
		int memberMobile = Integer.parseInt(sc.nextLine());
		
		int result = MemberDAO.getInstance().memberJoin(member);
		
	}
	
	
	
	
	//로그인 정보
	public static Member memberStatus = null;
	
	//로그인
	public void login() {
		Member member = new Member();
		
		System.out.print("ID > ");
		String memberId = sc.nextLine();
		
		System.out.print("PW > ");
		String memberPw = sc.nextLine();
		
		member = MemberDAO.getInstance().login(memberId);
		
		if(member != null) {
			if(memberPw.equals(member.getMemberPw())){
				System.out.println("로그인되었습니다.");
				memberStatus = member;
			}else {
				System.out.println("비밀번호가 다릅니다. 다시 입력하세요.");
			}
		}else {
			System.out.println("아이디가 다릅니다. 다시 입력하세요.");
		}	
	}
	
	//로그아웃
	public void logout() {
		if(memberStatus != null) {
			memberStatus = null;
			System.out.println("정상적으로 로그아웃되었습니다.");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
