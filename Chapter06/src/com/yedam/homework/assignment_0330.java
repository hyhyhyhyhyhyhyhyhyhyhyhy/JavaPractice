package com.yedam.homework;

import java.util.Scanner;

public class assignment_0330 {

	public static void main(String[] args) {
		// 문제2) 다음은 키보드로부터 상품 수와 상품 가격을 입력받아서
			// 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총 합을 구하는 프로그램을 작성하세요.
			// 1) 메뉴는 다음과 같이 구성하세요.
			// 1.상품 수 | 2.상품 및 가격입력 | 3.제품별 가격 | 4.분석 | 5.종료
			// 2) 입력한 상품 수만큼 상품명과 해당 가격을 입력받을 수 있도록 구현하세요.
			// 3) 제품별 가격을 출력하세요.
			//	출력예시, "상품명 : 가격"
			// 4) 분석기능은 최고 가격을 가지는 제품과 해당 제품을 제외한 제품들의 총합을 구합니다.
			// 5) 종료 시에는 프로그램을 종료한다고 메세지를 출력하도록 구현하세요.
		
		Scanner sc = new Scanner(System.in);
		int pdCount = 0;
		Product[] goAry = null;
		
		while(true) {
			System.out.println("1. 상품 수 | 2. 상품 및 가격입력 | 3. 제품별 가격 | 4. 분석 | 5. 종료");
			System.out.print("메뉴 입력 > ");
			String selectNo = sc.nextLine();
			System.out.println();
			
			if(selectNo.equals("1")) {
				//상품 수 입력 받기
				System.out.print("등록할 상품 수를 입력하세요. > ");
				pdCount = Integer.parseInt(sc.nextLine());
				
				//입력받은 상품 수만큼 배열 생성
				goAry = new Product[pdCount];
				
				System.out.println();
				
			}else if(selectNo.equals("2")) {				
				//상품명과 가격이 입력될 때마다 배열의 객체에 저장
				for(int i=0; i<goAry.length; i++) {
					goAry[i] = new Product();
					System.out.print("상품명 입력> ");
					String name = sc.nextLine();
					goAry[i].goods = name;
					
					System.out.print("상품가격 입력> ");
					int price = sc.nextInt();
					sc.nextLine();
					goAry[i].price = price;
					
					System.out.println();
				}
			}else if(selectNo.equals("3")) {
				//제품별 가격 조회
				System.out.println("==========등록상품 조회==========");
				for(int i=0; i<goAry.length; i++) {
				System.out.println("상품명 : " + goAry[i].goods + "\t" + "가격 : " + goAry[i].price + "원");
				}
				System.out.println();
				
			}else if(selectNo.equals("4")) {
				//분석 기능 추가
				int max = goAry[0].price;
				String maxName = goAry[0].goods;
				int total = 0;
				for(int i = 0; i<goAry.length; i++) {
					total = total + goAry[i].price;
					if(max < goAry[i].price) {
						max = goAry[i].price;
						maxName = goAry[i].goods;
					}
				}
				System.out.println("최고가의 상품 : " + maxName);
				int difference = total - max;
				System.out.println("최고가 상품을 제외한 상품들의 총합 : " + difference + "원");
				System.out.println();
				
			}else if(selectNo.equals("5")){
				System.out.println("프로그램 종료");
				break;
			}else {
				System.out.println("없는 메뉴입니다. 다시 입력하세요.");
			}
			
		}
		

	}

}
