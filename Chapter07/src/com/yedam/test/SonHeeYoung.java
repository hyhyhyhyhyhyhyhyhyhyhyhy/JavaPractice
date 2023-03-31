package com.yedam.test;

import java.util.Scanner;

public class SonHeeYoung {

	public static void main(String[] args) {
		
		//문제 1
		int x = 10;
		double y = 2.0;
		
		int sum = x + (int) y;
		int sub = x - (int) y;
		int multiple = x * (int) y;
		int division = x / (int) y;
		
		System.out.println("x + y = " + sum);
		System.out.println("x - y = " + sub);
		System.out.println("x * y = " + multiple);
		System.out.println("x / y = " + division);
		System.out.println();
		
		
		//문제 2
		int num1 = 10;
		int num2 = 20;
		boolean result;
		
		result = ((num1>10) && (num2>10));
		System.out.println(result); // 두 식을 만족 못 시키므로 false
		result = ((num1>10) || (num2>10));
		System.out.println(result); // 하나의 식이라도 만족하면 true
		System.out.println(!result); // 최근 결과의 반대 false
		System.out.println();
		
		
		//문제 3
		int[] coinUnit = {500, 100, 50, 10};
		int money = 2680;
		int[] count = new int[4];
		
		System.out.println("money=" + money);
		for (int i = 0; i < coinUnit.length; i++) {
			count[i] = money / coinUnit[i];
			money -= coinUnit[i] * (money / coinUnit[i]);
		}
		
		System.out.print("500원 : " + count[0] + "개, ");
		System.out.print("100원 : " + count[1] + "개, ");
		System.out.print("50원 : " + count[2] + "개, ");
		System.out.print("10원 : " + count[3] + "개");
		System.out.println("\n");
		
		//교수님 풀이 > 3번
//		System.out.println(coinUnit[i]+"원 : " + money/coinUnit[i] + "개");
//		money = money%coinUnit[i];
		
		
		//문제 4
		for(int i=2; i<=9; i++) {
			for(int j=1; j<=i; j++) {
				System.out.println(i + "x" + j + "=" + i*j);
			}
			System.out.println();
		}
		
		
		//문제 5		
		Scanner sc = new Scanner(System.in);
		int size = 0; // 주사위 크기
		int[] dice = null;
		boolean run = true;
		
		while(run) {
			System.out.println("===1. 주사위 크기 2. 주사위 굴리기 3. 결과 보기 4. 가장 많이 나온 수 5. 종료 ===");
			System.out.println("메뉴 >");
			
			String selNo = sc.nextLine();
			System.out.println();
			
			switch (selNo) {
			case "1":
				System.out.println("주사위 크기?");
				size = Integer.parseInt(sc.nextLine());
				if(size < 5 || size > 10) {
					System.out.println("5~10 사이의 수를 입력하세요.");
					size = 0; //임의의 숫자로 바꿔버림
				}
				break;
			case "2":
				//주사위 크기 설정
				dice = new int[size];
				int countDice = 0;
				while(true) {
					//5가 언제 나올지 모르기 때문에, while로 나올때까지 반복문 실행하기 위해
					int random = (int)(Math.random()*size) + 1;
					System.out.println(random);
					//각 주사위 숫자 -> 배열 저장
					//주사위 숫자 1 2 3 4 5
					//배     열 0 1 2 3 4
					dice[random-1] = dice[random-1]+1; // 또는 ++; 도 된다.
					countDice++;
					if(random == 5) {
						break;
					}
				}
				System.out.println("5가 나올 때까지 주사위를 " + countDice + "번 굴렸습니다.");
				//만약 주사위의 크기가 5보다 작고 10보다 크다면..?
//				if(size != 0) {
//					//주사위를 돌린다.
//				}else {
//					System.out.println("주사위 크기를 재입력하세요.");
//				}
				break;
			case "3":
				for(int i = 0; i<dice.length; i++) {
					System.out.println((i+1)+"은" + dice[i]+"번 나왔습니다.");
				}
				break;
			case "4":
				int max = dice[0];
				int index = 0;
				for(int i=0; i<dice.length;i++) {
					if(max < dice[i]) {
						max = dice[i];
						index = 1;
					}
				}
				System.out.println("가장 많이 나온 수는 "+(index+1)+"입니다.");
				break;
			case "5":
				System.out.println("프로그램 종료");
				break;
			}
			
//	내가 한거			
//			if(selNo.equals("1")) {
//				System.out.print("주사위 크기 >");
//				range = Integer.parseInt(sc.nextLine());
//				if (range < 5 || range > 10) {
//					System.out.println("주사위 범위는 5~10 사이입니다.");
//				}
//			}else if(selNo.equals("2")) {
//				for(int i=0; i<range; i++) {
//					random[i] = (int)(Math.random()*10);
//					if(random[i] == 5) {
//						round = i;
//					}
//				}
//				System.out.println("5가 나올 때까지 주사위를 " + round + "번 굴렸습니다.");
//			}else if(selNo.equals("3")) {
//				
//			}else if(selNo.equals("4")){
//				
//			}else if(selNo.equals("5")) {
//				System.out.println("프로그램 종료");
//				break;
//			}else {
//				System.out.println("없는 메뉴입니다. 다시 입력하세요.");
//			}
		}
	}
}
