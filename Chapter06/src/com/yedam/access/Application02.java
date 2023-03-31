package com.yedam.access;

public class Application02 {

	public static void main(String[] args) {
		Access ac = new Access();
//		Scanner sc = new Scanner(System.in)
		
		//public
		ac.free = "public";
		//protected
		ac.parent = "protected";
		//default
		ac.basic = "default";
		//private
//		ac.privacy = "private";
		
		//같은 패키지 안에서만 가져올 수 있어서 shift +컨트롤 + o? 로 가져올 수 있다.

	}

}
