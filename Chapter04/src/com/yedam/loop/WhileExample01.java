package com.yedam.loop;

import java.util.Scanner;

public class WhileExample01 {

	public static void main(String[] args) {
		// 1~100사이에서 2의 배수만 출력
		int i = 1;
		while(i<=100) {
			if(i%2 == 0) {
				System.out.println(i);
			}
			i++;
		}

		Scanner sc = new Scanner(System.in);
		int menuNo = 0;
		while(menuNo != 4) {
			System.out.println("1. 덧셈 | 2. 뺄셈 | 3. 곱셈 | 4. 종료");
			System.out.println("메뉴선택>");
			//1~4
			menuNo = sc.nextInt();
			switch(menuNo) {
			case 1:
				System.out.println("덧셈 실행");
				break;
			case 2:
				System.out.println("뺄셈 실행");
				break;
			case 3:
				System.out.println("곱셈 실행");
				break;
			case 4:
				System.out.println("종료");
				break;
			}
		}
		
		//오락실
		int money;
		int menu = 0;
		System.out.println("====Insert Coin ====");
		money = sc.nextInt();
	
		//1) 게임 1회 실행 시 금액 500원 차감
		//2) 내가 투입한 금액만큼만 반목문을 돌린다.
		//	 + 종료 옵션 > 3번을 누르거나 금액이 소진되었을 때
		//4) 남은 게임 기회 표시 기능
		//	 ex) 1500원 -> 3번의 기회가 남았습니다.
	
		//while(menu != 3)
		
		while(money/500>0) {
			
			System.out.println("남은 기회는 " + (money/500) + "번 입니다.");
			
			System.out.println("1. 가위바위보 | 2. 앞 뒤 맞추기 | 3. 종료");
			System.out.println("입력>");
			menu = sc.nextInt();

					if(menu == 1) {
						money -= 500;
						System.out.println("가위바위보");
					}else if(menu == 2) {
						money -= 500;
						System.out.println("앞 뒤 맞추기");
					}else if(menu == 3) {
						System.out.println("오락실 종료");
						break;
					}else {
						System.out.println("없는 메뉴입니다.");
					}
		}
	
		//do while 문
		int month;
		do {
			System.out.println("올바른 월을 입력하세요(1~12)");
			month = sc.nextInt();
		}while (month<1 || month>12);
		
		
		//break, continue
		//무한 루프 > 항상 true > 항상 조건만족 > 반복문이 계속 실행
		while(true) {
			int num = (int)(Math.random()*6)+1;
			if(num == 6) {
				break; //탈출 조건이 없을 경우, 무한 루프되는 코드로 다음 작업 실행 불가
			}
		}
		
		System.out.println("브레이크 안 쓸 경우");
		
		//중첩 for문 안에서의 break;
		for(int j = 0; j<=10; j++) {
			for(int k=0; k<=10; k++) {
				if(j+k == 4) {
					System.out.println("j + k = " + (j+k));
					break; // 자기가 속해있는 반복문만 종료시킴
				}
			}
		}
		
		Outter : for(char upper = 'A'; upper <= 'Z'; upper++) {
			for(char lower = 'a'; lower <= 'z'; lower++) {
				System.out.println(upper + "-" + lower);
				if(lower == 'g') {
					break Outter; //지정한 반복문 종료 (라벨링)
				}
			}
		}
		
		//continue
		//continue를 기준으로 반복문 재 실행
		for(int j = 0; j<=10; j++) {
			if(j%2 == 0) {
				continue; //아래에 있는 실행문 실행 안하고 반복문의 마지막에 위치 다시 올라감
			}
			System.out.println(j);
		}
	}

}
