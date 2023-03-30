package com.yedam.oop;

public class Car {
		//필드 -> 객체의 정보
		String name;
		int price;
		String company = "현대자동차";
		
		//생성자
		//기본생성자
		public Car() {
			
		}
//		//매개변수를 가지는 생성자
		public Car(String name) {
			this(name, 10000,"기아자동차"); //생성자를 호출하는 this() 키워드
		}
		public Car(int price) {
			this.price = price;
		}
		public Car(String name, int price) {
			this.name = name;
			this.price = price;
		}
		public Car(int price, String name) {
			this.name = name;
			this.price = price;
		}
		public Car(String name, int price, String company) {
			this.name = name;
			this.price = price;
			this.company = company;
		}
//		public Car(String n, int p) {
//			name = n;
//			price = p;
//		} // 웬만하면 따로 지정안하는게 좋음
		
		//This를 이용한 필드 초기화
//		public Car(String name, int price) {
//			this.name = name;
//			this.price = price;
//		}
		//메소드
}
