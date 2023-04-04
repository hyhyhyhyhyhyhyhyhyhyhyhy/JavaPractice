package com.yedam.API;

import java.util.Scanner;

public class StringTrials {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//문제 1] 문자열 뒤집기
		//예시 : 입력 > "12345678"
	    //      출력 > "87654321"
		
		System.out.print("문자열을 입력하세요 > ");
		String input1 = sc.nextLine();
		
		for(int i=input1.length()-1; i>=0; i--) {
			StringBuilder sb = new StringBuilder();
			sb.append(input1.charAt(i));
			System.out.print(sb);
		}
		
		System.out.println('\n');
		
		//교수님 풀이 1번
//		String str = sc.nextLine();
//		String str2="";
//		for(int i = str.length()-1; i>=0; i--) {
//			//charAt
//			char temp = str.charAt(i);
//			str2 += temp;
//		}
//		System.out.println(str2);

		
		
		
		//문제 2] 문자열 개수 세기
		// 입력되는 문자열을 뒤집어 출력하라
		// 알파벳, 숫자, 공백의 갯수
		
		System.out.print("알파벳과 숫자를 포함하는 문자열을 입력하세요.(공백 포함 가능) > ");
		String input2 = sc.nextLine();
		
		for(int i=input2.length()-1; i>=0; i--) {
			StringBuilder sb = new StringBuilder();
			sb.append(input2.charAt(i));
			System.out.print(sb);
		}
		
		System.out.println();
		
		int alpha = 0;
		int num = 0;
		int blank = 0;
		
		for(int i=input2.length()-1; i>=0; i--) {
			if(input2.charAt(i) >= 48 && input2.charAt(i) <= 57) {
				num += 1;
			}else if((input2.charAt(i) >= 65 && input2.charAt(i) <= 90) || (input2.charAt(i) >= 97 && input2.charAt(i) <= 122)) {
				alpha += 1;
			}else {
				blank += 1;
			}
	
		}
		
		
		System.out.println();
		System.out.println("알파벳 : " + alpha + " 숫자 : " + num + " 공백 : " + blank);

		//교수님 풀이 2번

//		int alpha = 0;
//		int number = 0;
//		int blank = 0;
//		System.out.println("문자열 입력>");
//		String str3 = sc.nextLine();
//		for(int i = 0; i<str3.length(); i++) {
//			char temp = str3.charAt(i);
//			if(temp == ' ') {
//				blank++;
//			}else if(temp >= '0' && temp <= '9') {
//				number++;
//			}else if(temp >='a' && temp <='z') {
//				alpha++;
//			}
//		}
//		
//		System.out.println("공백 : " + blank + " 숫자 : " + number + " 알파벳 : " + alpha);
		
		
		
		
		//문제 3] 문자열 압축
		// 예시 : 입력 >"YYYEEDDDYYYMMMAAA";
		//       출력 >Y3E2D3Y3M3A3
		
		//교수님 풀이
		System.out.println("압축 문자열 입력>");
		String str4 = sc.nextLine();
		String str10 = "";
		char charTemp = str4.charAt(0);
		
		int count = 1;
		
		for(int i = 1; i<str4.length(); i++) {
			if(charTemp == str4.charAt(i)) {
				count++;
			}else{
				str10 = str10 + charTemp + count;
				count = 1;
			}
			charTemp = str4.charAt(i);
			if(str4.length()-1 == i) {
				str10 = str10 + charTemp + count;
			}

		}
		System.out.println(str10);

		
		
		//문제 4] 생년월일 입력 후 나이 출력하기(220101 -> 2022년생, 230202 -> 1923년생)
		//	     (단, 오늘 날짜 기준으로 생일이 지났으면 +1살, 안 지났으면 +0로 한다.)
		//	     (올해 기준 +- 100살까지만 구한다.)
		//	     예시) 
		//	       입력> 950101 
		//	       출력> 29
		//	       입력> 001013
		//	       출력> 23
		
			
		//교수님 풀이
			//1-1) 2000년 이후 2023년 이전 출생 (23-태어난 년도)+1
			//1-2 1922년 이후 2000년 이전 출생 (123-태어난년도)
			
		System.out.println();
		System.out.print("생년월일 6자리를 입력하세요. > ");
		String birth = sc.nextLine();
		
		int birthNo = Integer.parseInt(birth.substring(0,2));
				
				if(birthNo <= 23) {
					System.out.println("나이 : " + (23-birthNo+1));
				}else if(birthNo > 23) {
					System.out.println("나이 : " + (123-birthNo));
				}
		
		

		//문제 5] 중복 문자 갯수 세기
		//	     입력> aaabbccceedddd
		//       출력> a 3개, b 2개, c 3개, e 2개, d 4개
			
				
		//교수님 풀이
		//데이터를 입력 -> 중복문자가 몇개~?
		//a~z : 26ro
		//배열 인덱스 -> 0~25개의 크기를 가지는 배열
		//0 : ㅁ,, 1 : ㅠ,, 2 : c ... 25: z
				
		//아스키 코드
				
		//문자열 입력]
			System.out.println("문자열 입력>");
			String str5 = sc.nextLine().toLowerCase();
			int charAry[] = new int[26];
			
			for(int i = 0; i<str5.length(); i++) {
				char temp = str5.charAt(i);
				charAry[temp-'a']++;
			}
			
			for(int i=0; i<charAry.length; i++) {
				if(charAry[i] != 0) {
					System.out.println((char)(97+i) + " " + charAry[i]+"개");
				} 
			}
			
			

	}

}
