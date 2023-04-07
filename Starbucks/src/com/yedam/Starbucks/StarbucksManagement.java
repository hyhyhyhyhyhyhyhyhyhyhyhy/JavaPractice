package com.yedam.Starbucks;

import java.util.List;
import java.util.Scanner;

public class StarbucksManagement {
	
	Scanner sc = new Scanner(System.in);
	
	//1. 전체 조회
	public void getMenuList() {
		List<Starbucks> list = StarbucksDAO.getInstance().getMenuList();
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println("메뉴 : " + list.get(i).getCoffeeMenu() + "\t 가격 : " 
								+ list.get(i).getCoffeePrice());
			
		}
	}
	
	//2. 상세 조회
	public void getCertainMenu() {
		System.out.println("메뉴 입력>");
		String coffeeMenu = sc.nextLine();
		Starbucks menu = StarbucksDAO.getInstance().getMenuInfo(coffeeMenu);
		
		if(menu == null) {
			System.out.println("해당 메뉴는 존재하지 않습니다.");
		}else {
			System.out.print("메뉴 : " + menu.getCoffeeMenu() + "\t");
			System.out.print("가격 : " + menu.getCoffeePrice() + "\t");
			System.out.println("설명 : " + menu.getCoffeeExplain());
		}
	}
	
	
	//3. 메뉴 등록
	public void addMenu() {
		Starbucks menu = new Starbucks();
		
		System.out.println("메뉴 입력>");
		String menuName = sc.nextLine();
		
		System.out.println("가격 입력>");
		int menuPrice = Integer.parseInt(sc.nextLine());
		
		System.out.println("설명 입력>");
		String menuExplain = sc.nextLine();
		
		menu.setCoffeeMenu(menuName);
		menu.setCoffeePrice(menuPrice);
		menu.setCoffeeExplain(menuExplain);
		
		int result = StarbucksDAO.getInstance().addMenu(menu);
		
		if(result == 1) {
			System.out.println("메뉴 등록 완료");
		}else {
			System.out.println("메뉴 등록 실패");	
		}
	}
	
	
	//4. 판매
	
	
	//5. 메뉴 삭제
	public void deleteMenu() {
		System.out.println("메뉴 입력>");
		String delmenu = sc.nextLine();
		
		int result = StarbucksDAO.getInstance().deleteMenu(delmenu);
		
		if(result > 0) {
			System.out.println("메뉴 삭제 완료");
		}else {
			System.out.println("메뉴 삭제 실패");
		}		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
