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
		
		System.out.print("회원명 > ");
		String name = sc.nextLine();
		System.out.print("변경 시작일 > ");
		String date = sc.nextLine();
		Date startDate = Date.valueOf(date);
		
		Extension regi = new Extension();
		regi.setName(name);
		regi.setStartDate(startDate);
		
		int result = ExtensionDAO.getInstance().memberReregi(regi); 
		
		if(result > 0) {
			if(name.equals(MemberService.memberState.getName())) { 
				MemberService.memberState = MemberDAO.getInstance().login(name);  
			}
			System.out.println("재등록 회원 수정 완료");
		}else {
			System.out.println("재등록 회원 수정 실패");
		}
	}
	
	
	
	
}
