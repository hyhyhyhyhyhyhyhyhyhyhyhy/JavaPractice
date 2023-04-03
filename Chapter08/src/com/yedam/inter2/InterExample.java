package com.yedam.inter2;

public class InterExample {

	public static void main(String[] args) {
		InterfaceC ic = new ImplementnsC();
		ic.methodA();
		ic.methodB();
		ic.methodC();
		
		InterfaceB bc = new ImplementnsC();
		bc.methodB();
		
		InterfaceA ac = new ImplementnsC();
		ac.methodA();

	}

}
