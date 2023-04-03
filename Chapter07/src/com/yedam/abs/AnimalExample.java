package com.yedam.abs;

public class AnimalExample {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		dog.sound();
		cat.sound();
		System.out.println("------------------------------------");
		
		//추상 클래스를 다향성을 활용해서 표현
//		Animal animal = new Dog();
//		
//		animal.sound();
//		animal = new Cat();
//		animal.sound();
		
		animalSound(dog);
		animalSound(new Cat());
		
		//위 과정이 번거로우니 좀 더 쉽게 변환해보자
	}
	
	
	//매개변수의 다형성을 호라용한 추상 클래스 사용
	
	public static void animalSound(Animal animal) {
		animal.sound();
	}
	
}
