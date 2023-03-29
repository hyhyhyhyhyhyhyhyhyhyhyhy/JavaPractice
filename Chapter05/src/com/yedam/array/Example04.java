package com.yedam.array;

import java.util.Scanner;

public class Example04 {

	public static void main(String[] args) {
		// 배열에 담긴 최대, 최소값
		Scanner sc = new Scanner(System.in);
		
		int[] ary;
		int no;
		
		System.out.println("배열의 크기>");
		no = sc.nextInt(); //nextInt일 경우, 값만 가져감 엔터키 입력값은 남아있음
		sc.nextLine(); //엔터키까지 값으로 넘김
		ary = new int[no];
		
		//배열에 데이터 입력
		for(int i=0; i<ary.length; i++) {
			System.out.println("데이터 입력>"); //nextLine()이 없다면, Int의 엔터값이 남아 아래의 nextLine을 받아버려서 오류가 생김
			ary[i] = Integer.parseInt(sc.nextLine());
		}

		//최대값 구하기
		int max = ary[0];
		for(int i = 0; i<ary.length; i++) {
			if(max < ary[i]) {
				max = ary[i];
			}
		}
		System.out.println("최대값 : " + max);
		
		//최소값 구하기		
		int min = ary[0];
		for(int i = 0; i<ary.length; i++) {
			if(min > ary[i]) {
				min = ary[i];
			}
		}
		System.out.println("최소값 : " + min);
	}
}
