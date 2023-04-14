package com.yedam.pt;

import java.util.Scanner;

import com.yedam.member.MemberDAO;
import com.yedam.member.MemberService;

public class PtService {

	Scanner sc = new Scanner(System.in);	
	//관리자 - PT 회원 수정
	
	public void ptMemberUpdate() {
		String name = "";
		String grade = "";
		String ptTrainer = "";
		int ptTotal = 0;
		int ptIng = 0;
		
		System.out.print(" 회원명 ▶ ");
		name = sc.nextLine();
		System.out.print("회원구분 변경 [P,N 중 선택] > ");
		grade = sc.nextLine();
		
		if(grade.equals("P")) {
			System.out.print("담당 트레이너 지정 > ");
			ptTrainer = sc.nextLine();
			System.out.print(" PT 등록 횟수 ▶");
			ptTotal = Integer.parseInt(sc.nextLine());
			System.out.print(" 현재 PT 진행 횟수 ▶ ");
			ptIng = Integer.parseInt(sc.nextLine());
		}
		
		Pt ptUpdate = new Pt();
		ptUpdate.setName(name);
		ptUpdate.setGrade(grade);
		ptUpdate.setPtTrainer(ptTrainer);
		ptUpdate.setPtTotal(ptTotal);
		ptUpdate.setPtIng(ptIng);
		
		int result = PtDAO.getInstance().ptMemberUpdate(ptUpdate); 
		
		if(result > 0) {
			if(name.equals(MemberService.memberState.getName())) { 
				MemberService.memberState = MemberDAO.getInstance().login(name);  
			}
			System.out.println(" 재등록 회원 수정 완료");
		}else {
			System.out.println(" 재등록 회원 수정 실패");
		}
	}
	
	
	
	
	
	
}
