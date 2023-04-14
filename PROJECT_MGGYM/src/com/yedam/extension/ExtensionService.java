package com.yedam.extension;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.yedam.member.MemberDAO;
import com.yedam.member.MemberService;


public class ExtensionService {

	Scanner sc = new Scanner(System.in);
	
	//관리자 - 재등록 회원 수정
	
	public void memberReregi() {
		
		System.out.print(" 회원명 ▶ ");
		String name = sc.nextLine();
		System.out.print(" 운동 시작일 ▶ ");
		String date = sc.nextLine();
		Date startDate = Date.valueOf(date);
		System.out.print(" 등록 개월 수 ▶ ");
		int regiMonth = Integer.parseInt(sc.nextLine());
		
		int avaExtend = 0;
		while(regiMonth >= 3) {
			if(regiMonth < 6) {
				avaExtend += 14;
				break;
			}else if(regiMonth < 12) {
				avaExtend += 30;
				break;
			}else if(regiMonth >= 12) {
				int year = regiMonth / 12;
			regiMonth = regiMonth % 12;
				avaExtend = year*60;
			}
		}
		System.out.print(" 등록 구분 ▶ ");
		String grade = sc.nextLine();
		
		Extension regi = new Extension();
		regi.setName(name);
		regi.setStartDate(startDate);
		regi.setRegiMonth(regiMonth);
		regi.setAvaExtendDay(avaExtend);
		regi.setGrade(grade);
		
		int result = ExtensionDAO.getInstance().memberReregi(regi, avaExtend); 
		
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
