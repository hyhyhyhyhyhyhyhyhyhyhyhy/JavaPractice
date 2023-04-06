package com.yedam.member;

import java.util.List;
import java.util.Scanner;

public class MemberService {
	//impl = service
	//로그인,, 메뉴를 이동할 때마다 그 로그인 정보가 남아있어야한다.
	//정적 멤버(static) - 어디서든지 공유해줄 수 있음 
	//1. login
		//login 성공 
		//login -> id/pw -> 정보 조회 성공 -> 로그인
		//로그인 -> 정적 필드에게 로그인한 정보를 입력
	
		//login 실패
		//정보 조회 실패 -> 정적 필드에 데이터를 넣지 않음
	
	//★★★★★
	public static Member memberInfo = null; //means public > 공용 , static > 공유, Member > 객체타입, memberInfo > 객체, null > 객체 없음
	
	Scanner sc = new Scanner(System.in);
	
	public void login() {
		// id 입력
		System.out.print("ID > ");
		String id = sc.nextLine();
		
		System.out.print("PW > ");
		String pw = sc.nextLine();
		
		//1. member == null (id가 없다)
		//2. member != null (회원 정보가 있다)
		Member member = MemberDAO.getInstance().login(id);
		
		if(member != null) {
			if(member.getPw().equals(pw)) {
				System.out.println("정상 로그인 되었습니다.");
				System.out.println(member.getName() + "님 환영합니다.😊");
				memberInfo = member;
			}else {
				System.out.println("비밀번호가 틀렸습니다.");
			}
		}else {
			System.out.println("아이디가 존재하지 않습니다.");
		}
	}
	
	public void logout() {
		memberInfo = null;
		System.out.println("로그아웃 성공");
	}
	
	
	//전체 조회
	public void getMemberList() {
		List<Member> list = MemberDAO.getInstance().getMemberlist();
		
		for(Member member : list) {
			System.out.println("ID : " + member.getId());
			System.out.println("PW : " + member.getPw());
			System.out.println("NM : " + member.getName());
		}
	}
	
	//회원 등록
	public void memberAdd() {
		
		String id = "";
		while(true) {
			System.out.print("ID> ");
			id = sc.nextLine();
			Member member = MemberDAO.getInstance().login(id);
			if(member == null) { // 만약 if문 안에 변수 선언 없이 메소드를 넣는 다면 반드시 해당 메소드가 실행되고 나서 결과값을 받는 거라고 생각하면 됨 >> 이게 무슨 말이지...?
				System.out.println("회원 가입 가능");
				break;
			}else {
				System.out.println("ID 중복, 재입력");
			}
		}
		System.out.print("PW> ");
		String pw = sc.nextLine();
		System.out.print("이름> ");
		String name = sc.nextLine();
		
		Member member = new Member(); 
		member.setId(id);
		member.setPw(pw);
		member.setName(name);
		
		int result = MemberDAO.getInstance().memberAdd(member);
		
		if(result == 1) {
			System.out.println("회원 등록 성공");
		}else {
			System.out.println("회원 등록 실패");
		}
	}
	
	
	//회원 수정
	//login 되어 있는 정보를 수정 -> 실시간으로 로그인 된 정보도 바꿔 줘야한다. (v)
	//login 안되어 있는 정보를 수정하는지
	//고민해볼 필요가 있음
	
	public void memberUpdate() {
		//비밀번호 바꾸기
		
		System.out.print("정보 변경할 ID > ");
		String id = sc.nextLine();
		System.out.print("변경 PW > ");
		String pw = sc.nextLine();
		
		Member member = new Member();
		member.setId(id);
		member.setPw(pw);
		
		int result = MemberDAO.getInstance().memberUpdate(member); //DB에 정보 업데이트 하는 작업
		
		if(result > 0) {
			//로그인된 정보 변경 실시간으로 정보 업데이트 필요
			if(id.equals(memberInfo.getId())) { //로그인한 id랑 입력된 id랑 비교 > 로그인한 사람의 정보를 바꿀건지 아닌지 확인하는 작업이다.
				memberInfo = MemberDAO.getInstance().login(id); //해당 ID에 대한 DB정보를 조회해서 새롭게 갱신시키는 작업 
			}
			System.out.println("PW 변경 성공");
		}else {
			System.out.println("PW 변경 실패");
		}
	}
	
	
	
	public void memberDelete() {
		System.out.print("삭제 ID> ");
		String id = sc.nextLine();
		
		int result = MemberDAO.getInstance().memberDelete(id);
		
		if(result>0) {
			if(id.equals(memberInfo.getId())) {
				memberInfo = null;
		}else {
			System.out.println("삭제 완료");
		}
		}
	}
}
	
	

