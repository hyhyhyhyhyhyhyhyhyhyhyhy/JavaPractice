package com.yedam.API;

public class ClassExample {
	public static void main(String[] args) throws ClassNotFoundException {
		//class 클래스
		//Class에서 정보 얻기
		Class clazz = Member.class;
		System.out.println("Member Class 정보 : " + clazz);
		
		//클래스 경로 입력해서 정보 얻기
		clazz = Class.forName("com.yedam.API.Member"); //요거 많이 쓰임 // + 클래스를 찾지 못할 때 나오는 오류를 던져놓아야 컴파일러 오류가 풀림
		System.out.println(clazz);
		
		//객체를 통한 정보 얻기
		Member member = new Member("또치");
		clazz = member.getClass();
		System.out.println(clazz);
		System.out.println("==================================================");
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getPackageName());
		System.out.println(clazz.getPackage().getName());
		
		//절 대 경 로 // 같은 클래스에 이미지 파일 넣는 법 ctrl + c & ctrl + v
		String photoPath = clazz.getResource("profile_patrick.png").getPath();
		System.out.println(photoPath);
		
	}
}
