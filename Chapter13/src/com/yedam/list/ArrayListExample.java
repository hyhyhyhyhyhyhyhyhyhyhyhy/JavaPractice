package com.yedam.list;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
	public static void main(String[] args) {
		//String문자열을 넣을 수 있는 ArrayList
		List<String> list = new ArrayList<String>();
		
		//list 데이터 추가
		
		list.add("Java"); //인덱스 0 객체 추가
		list.add("JDBC"); //인덱스 1
		list.add("Servlet/JSP"); //인덱스 2
		
		list.add(2, "Database");
		list.add("iBatis");
		
		//list.size() =>list의 크기, 객체의 수 (배열의 length 비슷)
		for(int i = 0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : " + str);
		}
		
		//향상된 for문
		for(String str : list) {
			System.out.println(str);
		}
		
		
		System.out.println("=============================================");
		
		//list에 있는 인덱스 2번 객체 삭제
		list.remove(2);
		
		for(String str : list) {
			System.out.println(str);
		}
		
		
		//list에 저장된 객체를 활용해서 삭제
		list.remove("JDBC");
		
		for(int i = 0; i<list.size(); i++) {
			String str = list.get(i);
			System.out.println(i + " : " + str);
		}
		
		
		list.clear();
		System.out.println("list 사이즈 : " + list.size());
		
		
		
	}
}
