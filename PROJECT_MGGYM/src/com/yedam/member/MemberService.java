package com.yedam.member;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class MemberService {

	Scanner sc = new Scanner(System.in);
	
	//회원가입
	
	public void memberJoin() {
		Member member = new Member();
		
		System.out.println("***************** 회원가입 *******************");
		System.out.print(" 이름 ▶ ");
		String name = sc.nextLine();
		
		String id = "";
		while(true) {
			System.out.print(" 아이디 ▶ ");
			id = sc.nextLine();
			
			if(id.length()<=20) {
				if(MemberDAO.getInstance().login(id) == null) {
					System.out.println(" 아이디 중복 확인 완료.");
					break;
				}else {
					System.out.println(" 이미 존재하는 아이디입니다.");
					System.out.println();
				}
			}else {
				System.out.println(" 영문+숫자 조합 20자리 이하로 작성하세요.");
				System.out.println();
			}
		}
		
		System.out.print(" 비밀번호 ▶ ");
		String pw = sc.nextLine();
		
		while(true) {
			System.out.print(" 비밀번호 확인 ▶ ");
			String pw2 = sc.nextLine();
			if(pw2.equals(pw)) {
				System.out.println(" 비밀번호 확인 완료.");
				break;
			}else {
				System.out.println(" 비밀번호가 다릅니다. 다시 확인하세요.");
				System.out.println();
			}
		}
		
		System.out.println();
		System.out.println(" ※연락 가능한 번호로 입력부탁드립니다. \n '-'없이 작성하세요.");
		System.out.print(" 연락처 ▶ ");
		int mobile = Integer.parseInt(sc.nextLine());
		
		member.setId(id);
		member.setName(name);
		member.setPw(pw);
		member.setMobile(mobile);
		
		int result = MemberDAO.getInstance().memberJoin(member);
	}
	
	
	
	
	//로그인 정보
	public static Member memberState = null;
	
	//로그인
	public void login() {
		Member member = new Member();
		
		System.out.println("==================================");
		System.out.println("               로그인            ");
		System.out.println("==================================");
		
		while(true) {
			System.out.print(" √ 아이디 ▶ ");
			String id = sc.nextLine();
			
			member = MemberDAO.getInstance().login(id);
			
			if(member != null) {
				break;
			}else {
				System.out.println(" 없는 아이디 입니다. 다시 입력하세요.");
				System.out.println();
			}
		}
		
		while(true) {
			System.out.print(" √ 비밀번호 ▶ ");
			String pw = sc.nextLine();
			
			if(member != null) {
				if(pw.equals(member.getPw())){
					System.out.println(" 로그인 성공");
					memberState = member;
					break;
				}else {
					System.out.println(" 비밀번호가 다릅니다. 다시 입력하세요.");
					System.out.println();
				}
			}
		}
	}
	
	
	//로그아웃
	public void logout() {
		if(memberState != null) {
			memberState = null;
			System.out.println(" 로그아웃 완료");
			System.out.println();
		}
	}
	
	
	//---------------------------------------------------------------------
	
	
	
	//관리자 - 전체 조회
	public void getMemberList() {
		List<Member> list = MemberDAO.getInstance().getMemberList();
		if(list.size() == 0) {
			System.out.println(" 조회할 내용이 없습니다.");
		}  //수동으로 탭 맞춰보기!!
		System.out.println("아이디          회원명          연락처          시작일           종료일           회원구분            담당트레이너          피티 총 횟수          남은 횟수");
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i).getId() + " \t " + list.get(i).getName() +
					" \t " + list.get(i).getMobile() + " \t " + list.get(i).getRegiMonth() +
					" \t " + list.get(i).getStartDate() + list.get(i).getExpireDate() + 
					" \t " + list.get(i).getGrade() + list.get(i).getPtTrainer() +
					" \t " + list.get(i).getPtTotal() + list.get(i).getPtLeft());
		}
	}
	
	
	//관리자 - 회원명 조회 + 사용자 - 내 정보 조회
	public void getSearchMember() {	
		String username = "";
		if(memberState.getGrade().equals("M")) {
			System.out.print(" 검색 회원명 ▶ ");
			username = sc.nextLine();
		}else {
			username = memberState.getName();
		}
		Member member = MemberDAO.getInstance().getSearchMember(username);
		
		if(member == null) {
			System.out.println(" 회원이 존재하지 않습니다.");
		}else {
			System.out.println("\n〔 MGYM Member Information 〕");
			System.out.println(" ● 회원명 : " + member.getName() + "  \t\t" + " ● 연락처 : " + member.getMobile());
			System.out.println(" ● 아이디 : " + member.getId() + "\t" + " ● 비밀번호 : " + member.getPw());
			System.out.println(" ● 시작일 : " + member.getStartDate() + "\t" + " ● 종료일 : " + member.getExpireDate());
			if(member.getGrade().equals("P")) {
				System.out.print(" ● 담당 트레이너 : " + member.getPtTrainer() + "\t" );
				System.out.println(" ● 현재 기준 잔여 PT 횟수 : " + member.getPtLeft());
			}
			System.out.print(" ● 남은 연장기간 : " + member.getExtendLeft() + "일");
		} 
		System.out.println("\t ● 등록구분 : " + member.getGrade() + "\t\t");
		System.out.println();
	}
	
	
	//관리자 - 등급별 조회(단건)
	public void getSearchGrade() {
		System.out.println("\n 〔 등급별 회원 조회 〕");
		System.out.println("- 조회할 회원 구분 코드를 입력하세요.");
		System.out.println("※ 일반회원: N / PT회원: P ");
		System.out.print(" 입력 ▶ ");
		String grade = sc.nextLine();
		System.out.println();
		
		List<Member> list = MemberDAO.getInstance().getSearcGrade(grade);
		
			System.out.print("회원명      연락처 ");
			if(grade.equals("P")) {				
				System.out.print("     담당트레이너    잔여 PT 횟수");
			}
			for(Member member : list) {
				System.out.println();
				System.out.println("──────────────────────────────────────────────────────");
				System.out.print(member.getName() + "\t" + member.getMobile() + "\t");
			if(grade.equals("P")) {
				System.out.print(member.getPtTrainer() + "\t      " + member.getPtLeft());
			}
		}
		System.out.println();
	}
	
	
	//관리자 - 회원 추가
	public void memberAdd() {
		System.out.println("=====================================");
		System.out.println("              회 원 등 록");
		System.out.println("=====================================");
		
		System.out.print(" 회원 이름 ▶ ");
		String username = sc.nextLine();
		System.out.print(" 회원 아이디 ▶ ");
		String userId = sc.nextLine();
		System.out.print(" 회원 비밀번호 ▶ ");
		String userPw = sc.nextLine();
		System.out.print(" 회원 연락처 ▶ ");
		int contact = Integer.parseInt(sc.nextLine());
		System.out.println("※'YYYY-MM-DD'의 양식으로 작성하세요.");
		System.out.print(" 헬스장 등록일 ▶ ");
		String regist = sc.nextLine();
		System.out.print(" 회원 구분 ▶ ");
		String grade = sc.nextLine();
		System.out.print(" 등록 개월 수 ▶ ");
		int month = Integer.parseInt(sc.nextLine());
		
		int avaExtend = 0;
		while(month>=3) {
			if(month < 6) {
				avaExtend += 14;
				break;
			}else if(month < 12) {
				avaExtend += 30;
				break;
			}else if(month >= 12) {
				int year = month/12;
				month = month%12;
				avaExtend = year*60;
			}
		}
		System.out.print(" 헬스장 이용 시작일 ▶ ");
		String start = sc.nextLine();
		
		Member mem = new Member();
		mem.setId(userId);
		mem.setPw(userPw);
		mem.setName(username);
		mem.setMobile(contact);
		mem.setSignDate(Date.valueOf(regist));
		mem.setRegiMonth(month);
		mem.setStartDate(Date.valueOf(start));
		mem.setGrade(grade);
		
		int result = MemberDAO.getInstance().memberAdd(mem, avaExtend);
		
		if(result > 0) {
			System.out.println(" 회원등록이 완료되었습니다.");
		}else {
			System.out.println(" 회원등록이 정상적으로 처리되지 않았습니다.");
		}
	}
		
	
	//관리자 - 회원 삭제
	
	
	public void memberDelete() {
		System.out.print(" 삭제 회원명 ▶ ");
		String name = sc.nextLine();
		
		int result = MemberDAO.getInstance().memberDelete(name);
		
		if(result > 0) {
			System.out.println(" 회원 삭제 완료");
		}else {
			System.out.println(" 존재하지 않는 회원입니다.");
		}
	}
	
	
	//사용자 - 비밀번호 수정
	//아이디 안쓰고 현재 비밀번호 써서 확인하는 방법은?
	public void userPwUpdate() {
		
		String id = MemberService.memberState.getId();
		System.out.println(" ※보안을 위해 현재 비밀번호를 입력해주세요.");
		
		while(true) {
			System.out.print(" 비밀번호 ▶ ");
			String currentPw = sc.nextLine();
			
			if(!currentPw.equals(MemberService.memberState.getPw())) {
				System.out.println(" 비밀번호가 다릅니다. ");
				System.out.println();
			}else {
				break;
			}
		}
		
		String pw = "";
		while(true) {
			System.out.print(" 변경 비밀번호 ▶ ");
			pw = sc.nextLine();
			
			System.out.print(" 비밀번호 확인 ▶ ");
			String pw2 = sc.nextLine();
			if(pw2.equals(pw)) {
				break;
			}else {
				System.out.println(" 비밀번호가 다릅니다. 다시 확인하세요.");
				System.out.println();
			}
		}
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		
		int result = MemberDAO.getInstance().userPwUpdate(member); 
		
		if(result > 0) {
			if(id.equals(memberState.getId())) { 
				memberState = MemberDAO.getInstance().login(id);  
			}
			System.out.println(" 비밀번호 변경 성공");
		}else {
			System.out.println(" 비밀번호 변경 실패");
		}
	}
	
	
	
	//사용자 - 연락처 수정
	public void userMobileUpdate() {
		String id = MemberService.memberState.getId();
		
		System.out.println("※연락 가능한 번호로 입력부탁드립니다. \n '-'없이 작성하세요.");
		System.out.print(" 변경 연락처 ▶ ");
		int mobile = Integer.parseInt(sc.nextLine());
		
		Member member = new Member();
		member.setId(id);
		member.setMobile(mobile);
		
		int result = MemberDAO.getInstance().userMobileUpdate(member); 
		
		if(result > 0) {
			if(id.equals(memberState.getId())) { 
				memberState = MemberDAO.getInstance().login(id);  
			}
			System.out.println(" 연락처 변경 성공");
		}else {
			System.out.println(" 연락처 변경 실패");
		}
	}
	
	

	
	
	
	
	
	
	
}
