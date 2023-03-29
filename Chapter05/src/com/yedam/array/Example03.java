package com.yedam.array;

import java.util.Scanner;

public class Example03 {

	public static void main(String[] args) {
		//한 학생의 국어, 영어, 수학 점수를 배열에 담아서 성적 관리
		
		//{국어, 영어, 수학} 데이터가 들어간다고 가정하에
		
		Scanner sc = new Scanner(System.in);
		
		int[] point = new int[3];
		
		//학생의 성적 입력
		//국어
		//영어
		//수학
		
		System.out.println("국어 성적을 입력하세요> ");
		point[0] = sc.nextInt();
		System.out.println("영어 성적을 입력하세요> ");
		point[1] = sc.nextInt();
		System.out.println("수학 성적을 입력하세요> ");
		point[2] = sc.nextInt();
		
		
		//학생의 점수 총 합계
		
		System.out.println();
		
		int sum = 0;
		double avg = 0;
		
		for(int i=0; i<=point.length; i++) {
			sum = sum + point[i];
		}
		
		System.out.println("점수의 총 합은 " + sum + "입니다.");
		
		//학생의 성적 평균 
		
		avg = (double)sum / point.length;
		
		System.out.println("점수의 평균은 " + avg + "입니다.");
		
		
	}

}
