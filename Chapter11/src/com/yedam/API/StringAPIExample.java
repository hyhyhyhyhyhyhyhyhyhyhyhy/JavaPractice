package com.yedam.API;

public class StringAPIExample {
	public static void main(String[] args) {
		//byte[] -> String 변환
		byte[] bytes = {72,101,108,108,111,32,74,97,118,97};
		
		String str1 = new String(bytes);
		System.out.println(str1);
		
		//내가 원하는 위치를 선정(6)하고 그 갯수만큼 출력(4)
		String str2 = new String(bytes, 6,4); //Java의 경우, 인덱스는 항상 0부터 시작
		System.out.println(str2);
		
		
	}
}
