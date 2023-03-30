package com.yedam.homework;

public class Product {
	//필드
	String goods;
	int price;

	//생성자
	public Product() {
	
	}
	public Product(String goods) {
	this.goods = goods;
	}
	public Product(int price) {
		this.price = price;
	}
	
	//메소드
	void getInfo() {
		System.out.println("============제품별 가격============");
		System.out.println(goods + "\t" + price + "원");
	}	
}