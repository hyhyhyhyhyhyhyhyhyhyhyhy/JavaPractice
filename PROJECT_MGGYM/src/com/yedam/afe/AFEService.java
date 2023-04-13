package com.yedam.afe;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

import com.yedam.extension.Extension;
import com.yedam.extension.ExtensionDAO;
import com.yedam.member.MemberService;

public class AFEService {

	Scanner sc = new Scanner(System.in);
	
	//사용자 - 연장 신청
	
	public void applyExtension() {
		
		System.out.println("======================== 연장 신청 안내 =========================");
		System.out.println("믓GYM에서는 부득이한 사정으로 센터에 나오실 수 없는 분들을 위해\r\n"
				+ "미리 신청하신 기간에 한하여 센터 이용 기간을 늘려드리고 있습니다.\r\n"
				+ "필요하실 때마다  신청 주시면 자동 적용되오며,\r\n"
				+ "연장 신청 기간 동안에는 센터를 이용하실 수 없음을 알려드립니다. 감사합니다.");
		System.out.println("==============================================================");

		System.out.print("연장 신청 가능 일수 > ");
		System.out.println(ExtensionDAO.getInstance().searchExtendDay());
		
		System.out.println("연장하시겠습니까? [Y/N]");
		System.out.print("입력 > ");
		String sel = sc.nextLine();
		
		if(sel.equals("Y")) {
			System.out.print("연장 시작 날짜 > ");
			String date = sc.nextLine();
			Date applydate = Date.valueOf(date);
			
			System.out.print("정지 일수 > ");
			int period = Integer.parseInt(sc.nextLine());
			
			Extension extend = ExtensionDAO.getInstance().getExtendList();
			
			if(period > extend.getExtendLeft()) {
				System.out.println("연장 가능한 신청일수는 최대 " + extend.getExtendLeft() + "일입니다.");
				System.out.println("다시 입력해주세요.");
			}else {
				AFE applyExtend = new AFE();
				
				applyExtend.setApplyerName(MemberService.memberState.getName());
				applyExtend.setExtendPeriod(period);
				applyExtend.setAppliedDate(applydate);
				
				int result = AFEDAO.getInstance().extendApplyUpdate(applyExtend);
				if(result > 0) {
					System.out.println("안녕하세요 " + MemberService.memberState.getName() + "님 :)");
					
					Calendar cal = Calendar.getInstance();
					DateFormat df = new SimpleDateFormat("yy/MM/dd");
					
					cal.setTime(applydate);
					
					cal.add(Calendar.DATE, period);
					
					System.out.println("[" + df.format(applydate) + "] ~ " + "[" + df.format(cal.getTime()) + "]"
								+ " 연장신청이 완료되었습니다.");
					
					cal.add(Calendar.DATE, 1);
					System.out.println("[" + df.format(cal.getTime())+ "]" + "부터 센터 재이용이 가능합니다. 감사합니다." );
				}
			}
		}else {
			return;
		}
	
	}

	
	
	
	
	
	
}
