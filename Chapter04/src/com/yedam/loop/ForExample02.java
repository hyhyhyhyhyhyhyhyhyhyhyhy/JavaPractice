package com.yedam.loop;

public class ForExample02 {

	public static void main(String[] args) {
		//중첩 반복문
		//2단 ~ 9단 구구단 출력
		for(int i=2; i<=9; i++) {
			System.out.println("==========" + i + "단==========");
			for(int j=1; j<=9; j++) {
				System.out.println(i + "*" + j + "=" + (i*j));
			}
		}
		
		//공포의 별찍기
		//*****
		//*****
		//*****
		//*****
		//*****
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//* 	1줄 1개
		//**	2줄 2개
		//***	3줄 3개
		//****	4줄 4개
		//*****	5줄 5개
		
		for(int i=1; i<=5; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		//*****		1줄 5개 
		//****		2줄 4개
		//***		3줄 3개
		//**		4줄 2개
		//*			5줄 1개
		
		//교수님 풀이
		for(int i=5; i>=0; i--) {
			for(int j=i; j>0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
