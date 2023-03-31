package com.yedam.inheri;

public class DmbCellPhone extends CellPhone {
	//자식 클래스
	//필드
	int channel;
	
	//생성자
	//부모 클래스 객체를 따로 만들지 않아도 자식 클래스에서 부모 생성자를 실행해 자식겸 부모 객체를 생성하는것 
	//그럴 경우, 부모클래스의 인스턴스 필드, 인스턴스 메소드 모두 사용 가능
	public DmbCellPhone(int channel, String color, String model) {
		//부모 클래스 기본 생성자 함수를 주석 처리하면,
		//부모 클래스에 있는 생성자를 사용하는 키워드 : super()
		super(model, color);
		this.channel = channel;
	}
	
	//메소드
	public void turnOnDMB() {
		System.out.println("채널" + channel + "번 DMB 방송 수신");
	}
	public void turnOffDMB() {
		System.out.println("DMB 방송 수신을 멉춥니다.");
	}
}
