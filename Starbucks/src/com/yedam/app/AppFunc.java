package com.yedam.app;

import java.util.Scanner;

import com.yedam.Starbucks.StarbucksManagement;

public class AppFunc {
	
	StarbucksManagement sm = new StarbucksManagement();
	Scanner sc = new Scanner(System.in);
	
	public AppFunc() {
		run();
	}
	
	private void run() {
		while(true) {
			System.out.println("1. 메뉴 조회 | 2. 메뉴 상세 조회 | 3. 메뉴 등록 | 4. 판매 | 5. 메뉴 삭제 | 6. 매출 | 7. 종료");
			System.out.println("메뉴 입력>");
			int num = Integer.parseInt(sc.nextLine());
			
			if(num == 1) {
				sm.getMenuList();
			}else if(num == 2) {
				sm.getCertainMenu();
			}else if(num == 3) {
				sm.addMenu();
			}else if(num == 4) {
				
			}else if(num == 5) {
				sm.deleteMenu();
			}else if(num == 6) {
				
			}else if(num == 7) {
				System.out.println("end of prog");
				break;
			}
			
		}
	}
	
	
	
	
	
	
	
	
	
}
