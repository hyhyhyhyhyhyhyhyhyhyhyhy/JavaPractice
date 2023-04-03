package com.yedam.inter;

public class RemoteExample {

	public static void main(String[] args) {
		RemoteControl rc;
		rc = new Audio();
		rc = new Television();
		
		rc.turnOn();
		rc.setVolume(5);
		rc.setVolume(12);
		rc.setVolume(-5);
		rc.turnOff();
		
		SmartTelevision tv = new SmartTelevision();
		
		//2개의 인터페이스를 상속 = tv
		
		RemoteControl rc2 = tv;
		
		rc2.turnOn();
		rc2.setVolume(4);
		rc2.turnOff();
		
//		rc2.search("naver";) //tv 클래스에는 search가 없기 때문에 빨간 줄
		
		Searchable search = tv;
		
		tv.search("www.naver.com");		
		search.search("www.naver.com");
		//인터페이스 간 상속으로 searchable 과 remoteControl을 합쳐 쓸 숭 씨다1!
		search.turnOff();
		search.setVolume(8);
		search.turnOn();

	}

}
