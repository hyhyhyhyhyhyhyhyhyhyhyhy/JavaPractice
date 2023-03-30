package com.yedam.access;

public class Application {

	public static void main(String[] args) {
		Access ac = new Access();
		
		//public
		ac.free = "public";
		
		//protected
		ac.parent = "parent";
		
		//default
		ac.basic = "default";
		
		//private
//		ac.privacy = "private"	; //외부에서 못씀
		

	}

}
