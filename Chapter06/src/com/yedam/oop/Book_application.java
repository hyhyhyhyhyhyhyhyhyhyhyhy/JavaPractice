package com.yedam.oop;

public class Book_application {

	public static void main(String[] args) {
		Book book1 = new Book ("혼자 공부하는 자바", 24000, "한빛 미디어", "yedam001");
		book1.getInfo();
		
		System.out.println("\n");
		
		Book book2 = new Book ("HTML", 15000, "길벗", "yedam002");
		book2.getInfo();
		
		System.out.println("\n");
		
		Book book3 = new Book ("Java Script", 20000, "한빛 미디어", "yedam003");
		book3.getInfo();

	}

}
