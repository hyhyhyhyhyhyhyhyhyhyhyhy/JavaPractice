package com.yedam.oop;

public class Application02 {

	public static void main(String[] args) {
		Car sonata = new Car ("소나타", 10000); //Car라는 생성자를 통해 어떠한 일을 수행하고 객체를 만들겠다는 뜻
		//sonata는 Car라는 클래스로 만들어진 객체
		//맨 앞의 Car는 클래스 기능을 사용할 수 있게끔 한다.
		
		//sonata 정보 출력하기
		System.out.println(sonata.company);
		System.out.println(sonata.name);
		System.out.println(sonata.price);
		
		Car k5 = new Car("K5", 9000, "기아자동차");
		System.out.println(k5.company);
		System.out.println(k5.name);
		System.out.println(k5.price);
		
//		sonata.name = "소나타"
//		sonata.price = 10000;
//		System.out.println();
//		System.out.println(sonata.company);
//		System.out.println(sonata.name);
//		System.out.println(sonata.price);
//		
//		//필드 값의 경우, 한번 정하고 끝이 아니라원할 때마다 값을 바꿀 수 있다
//		sonata.company = "기아자동차"
//				
//		System.out.println();
//		System.out.println(sonata.company);
//		System.out.println(sonata.name);
//		System.out.println(sonata.price);
//		
//		Car kona = new Car();
//		System.out.println("========코나========");
//		System.out.println(kona.company);
//		System.out.println(kona.name);
//		System.out.println(kona.price);
//		
//		kona.name = "코나";
//		kona.price = 100;
//		
//		System.out.println(kona.company);
//		System.out.println(kona.name);
//		System.out.println(kona.price);
	}

}
