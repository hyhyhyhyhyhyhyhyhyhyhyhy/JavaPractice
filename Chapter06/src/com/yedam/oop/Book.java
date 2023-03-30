package com.yedam.oop;

public class Book {
	//book이라는 클래스는 아래의 정보를 가집니다.
	//책이름, 책종류, 가격, 도서번호, 출판사
	//생성자는 3개 정도 생성
	
	//1) 기본 생성자
	//2) 모든 데이터를 초기화 할 수 있는 생성자
	//3) 책이름, 책 가격, 도서번호를 받아오는 생성자
	
	//메소드는 getInfo() 메소드 가짐
	//getInfo() 메소드를 클래스 외부에서 실행하였을 때,
	//다음과 같은 출력물이 나오도록 구현
	//객체.getInfo()
	//#책 이름 : 혼자 공부하는 자바
	//#내용
	//1) 종류 : 학습서
	//2) 가격 : 24000원
	//3) 출판사 : 한빛 미디어
	//4) 도서번호 : yedam001
	
	//#책 이름 : HTML
	//#내용
	//1) 종류 : 학습서
	//2) 가격 : 15000원
	//3) 출판사 : 길벗
	//4) 도서번호 : yedam003
	
	//#책 이름 : Java script
	//#내용
	//1) 종류 : 학습서
	//2) 가격 : 20000원
	//3) 출판사 : 한빛 미디어
	//4) 도서번호 : yedam003

	//필드
	String bookTitle;
	String genre = "학습서"; // 주어진 데이터가 모두 똑같아서 지정할 수 있음
	int price;
	String bookAgency;
	String isbn;
	
	//기본 생성자
	public Book() {
		
	}
	
	//생성자 필드 초기화
	public Book(String bookTitle, int price, String bookAgency, String isbn) {
		this.bookTitle = bookTitle;
		this.price = price;
		this.bookAgency = bookAgency;
		this.isbn = isbn;
	}
	
	//책이름, 책가격, 도서번호 생성자
	Book(String bookTitle, int price, String isbn){
		this.bookTitle = bookTitle;
		this.price = price;
		this.isbn = isbn;
	}
	
	//메소드
	void getInfo() {
		System.out.println("# 책 이름 : " + bookTitle);
		System.out.println("-----# 내용-----");
		System.out.println("1)종류 : " + genre);
		System.out.println("2)가격 : " + price);
		System.out.println("3)출판사 : " + bookAgency);
		System.out.println("4)도서번호 : " + isbn);
	}
	
	
}
