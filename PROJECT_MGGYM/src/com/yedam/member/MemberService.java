package com.yedam.member;

import java.util.List;
import java.util.Scanner;

public class MemberService {

	Scanner sc = new Scanner(System.in);
	
	//회원가입
	
	public void memberJoin() {
		Member member = new Member();
		
		System.out.println("============ 회원가입 =============");
		System.out.print("이름 > ");
		String name = sc.nextLine();
		
		String id = "";
		while(true) {
			System.out.print("아이디 >");
			id = sc.nextLine();
			
			if(MemberDAO.getInstance().login(id) == null) {
				break;
			}else {
				System.out.println("이미 존재하는 아이디입니다.");
			}	
		}
		
		System.out.print("비밀번호 > ");
		String pw = sc.nextLine();
		
		while(true) {
			System.out.print("비밀번호 확인 > ");
			String pw2 = sc.nextLine();
			if(pw2 == pw) {
				break;
			}else {
				System.out.println("비밀번호가 다릅니다. 다시 확인하세요.");
			}
		}
		
		System.out.print("연락처 > ");
		int mobile = Integer.parseInt(sc.nextLine());
		
		int result = MemberDAO.getInstance().memberJoin(member);
		
		System.out.println("회원가입이 완료되었습니다. 로그인 후 이용하세요.");
		
	}
	
	
	
	
	//로그인 정보
	public static Member memberState = null;
	
	//로그인
	public void login() {
		Member member = new Member();
		
		System.out.print("아이디 > ");
		String id = sc.nextLine();
		
		System.out.print("비밀번호 > ");
		String pw = sc.nextLine();
		
		member = MemberDAO.getInstance().login(id);
		
		if(member != null) {
			if(pw.equals(member.getPw())){
				System.out.println("로그인되었습니다.");
				memberState = member;
			}else {
				System.out.println("비밀번호가 다릅니다. 다시 입력하세요.");
			}
		}else {
			System.out.println("아이디가 다릅니다. 다시 입력하세요.");
		}	
	}
	
	//로그아웃
	public void logout() {
		if(memberState != null) {
			memberState = null;
			System.out.println("정상적으로 로그아웃되었습니다.");
		}
	}
	
	
	//---------------------------------------------------------------------
	
	
	//전체 조회
	public void getMemberList() {
		List<Member> list = MemberDAO.getInstance().getMemberList();
		
		System.out.println("아이디 \t 회원명 \t 연락처 \t 시작일 \t 종료일 \t 회원구분 \t 담당트레이너 \t 피티 총 횟수 \t 남은 횟수");
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i).getId() + " \t " + list.get(i).getName() +
					" \t " + list.get(i).getMobile() + " \t " + list.get(i).getStartDate() +
					" \t " + list.get(i).getExpireDate() + " \t " + list.get(i).getGrade() +
					" \t " + list.get(i).getPtTrainer() + " \t " + list.get(i).getPtTotal() + 
					" \t " + list.get(i).getPtLeft());
		}
		
		
		
	}
	
	
	//회원명 조회(단건)
	public void getSearchMember() {		
		System.out.print("검색 회원명 > ");
		String username = sc.nextLine();
		Member member = MemberDAO.getInstance().getSearchMember(username);
		
		if(member == null) {
			System.out.println("회원이 존재하지 않습니다.");
		}else {
			System.out.println("회원명 : " + member.getName() + "\t" + "연락처 : " + member.getMobile());
			System.out.println("아이디 : " + member.getId() + "\t" + "비밀번호 : " + member.getPw());
			System.out.println("시작일 : " + member.getStartDate() + "\t" + "종료일 : " + member.getExpireDate());
			System.out.println("등록구분 " + member.getGrade());
				if(member.getGrade().equals("P")) {
				System.out.print("담당 트레이너 : " + member.getPtTrainer() + "\t" );
				System.out.println("현재 기준 잔여 pt 횟수 : " + member.getPtLeft());
				}
			System.out.print("연장신청 여부 : " + member.getAvaExtendDay() + "\t" );
			System.out.println("남은 연장기간 : " + member.getExtendLeft() + "일");
		}
	}
	
	
	//등급별 조회(단건)
	public void getSearchGrade() {
		Member member = new Member();
		
		System.out.println("조회할 회원 구분 코드를 입력하세요.");
		System.out.println("※ 일반회원: N / PT회원: P ");
		System.out.print("입력 > ");
		String grade = sc.nextLine();
		
		if(grade == null) {
			System.out.println("다시 입력하세요.");
		}else {
			System.out.print("회원명 \t 연락처 \t 시작일 \t 종료일 ");
			if(grade == "N"){
				System.out.println();
				System.out.println("-------------------------------------------------------");
				System.out.println(member.getName() + "\t" + member.getMobile() + "\t" + 
						member.getStartDate() + "\t" + member.getExpireDate());
			}if(grade == "P") {
				System.out.println("\t 담당트레이너 \t 잔여 PT 횟수");
				System.out.println("-------------------------------------------------------");
				System.out.println(member.getName() + "\t" + member.getMobile() + "\t" + 
						member.getStartDate() + "\t" + member.getExpireDate() + "\t" +
						member.getPtTrainer() + "\t" + member.getPtLeft());
			}
		}
	}
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
