package com.yedam.inter;

public interface RemoteControl {
	//상수 => static final이 생략
	public int MAX_VOLUME = 10;
	public static final int MIN_VOLUME = 0;
	
	//추상 메소드 -> 인터페이스는 전부 추상메소드라 abstract 생략
	public void turnOn();
	public abstract void turnOff();; 
	public void setVolume(int volume);
}
