package com.yedam.minitest;

public class TestPerson {
	//필드
	private int ssn;
	String name;
	String address;
	
	
	//생성자
	TestPerson(){
		
	}
	TestPerson(int ssn, String name, String address){
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}
	
	//메소드
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
	
	
	
	
	
}
